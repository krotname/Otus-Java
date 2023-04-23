package ru.otus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;

class Ioc {
    private static final HashMap<Object[], Class<?>[]> MAP_ARGS = new HashMap<>();
    private static final HashMap<MethodWithClasses, Method> METHOD_WITH_CLASSES_METHOD_HASH_MAP = new HashMap<>();

    private Ioc() {
    }

    static TestLoggingInterface createTestLoggingInterface(Class<?> clazz) {
        InvocationHandler handler;
        try {
            handler = new LogInvocationHandler(clazz.getDeclaredConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return (TestLoggingInterface) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }

    static class LogInvocationHandler implements InvocationHandler {
        private final Object myObject;

        private LogInvocationHandler(Object o) {
            this.myObject = o;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Class<?>[] classes = this.getArgs(args);

            Method currentMethod = this.getCurrentMethod(MethodWithClasses.of(method, classes));

            if (currentMethod.isAnnotationPresent(Log.class)) {
                System.out.println("executed method: " + method.getName() + ", param: " + this.getArg(args));
            }
            return method.invoke(myObject, args);
        }

        private String getArg(Object[] args) {
            String arg = Arrays.toString(args);
            return arg.substring(1, arg.length() - 1);
        }

        private Method getCurrentMethod(MethodWithClasses methodWithClasses) {
            Method methodFomMap = METHOD_WITH_CLASSES_METHOD_HASH_MAP.get(methodWithClasses);
            if (methodFomMap != null) return methodFomMap;

            try {
                Method currentMethod = myObject.getClass().getMethod(methodWithClasses.getMethod().getName(), methodWithClasses.getClasses());
                METHOD_WITH_CLASSES_METHOD_HASH_MAP.put(methodWithClasses, currentMethod);
                return currentMethod;
            } catch (NoSuchMethodException | SecurityException ignored) {
            }
            throw new RuntimeException();
        }

        private Class<?>[] getArgs(Object[] args) {
            Class<?>[] classesFromMap = MAP_ARGS.get(args);
            if (classesFromMap != null) return classesFromMap;

            Class<?>[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
            MAP_ARGS.put(args, classes);
            return classes;
        }
    }


}
