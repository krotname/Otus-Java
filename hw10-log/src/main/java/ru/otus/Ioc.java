package ru.otus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

class Ioc {

    private Ioc() {
    }

    static TestLoggingInterface createTestLoggingInterface(Class<?> clazz) {
        InvocationHandler handler;
        try {
            handler = new LogInvocationHandler(clazz.getDeclaredConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
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
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { //todo Минимизировать вызов рефлексии в invoke и
            Class<?>[] classes = this.getClasses(args);

            Method currentMethod = getCurrentMethod(method, classes, method);

            if (currentMethod != null && currentMethod.isAnnotationPresent(Log.class)) {
                System.out.println("executed method: " + method.getName() + ", param: " + getArg(args));
            }
            return method.invoke(myObject, args);
        }

        private static String getArg(Object[] args) {
            String arg = Arrays.toString(args);
            return arg.substring(1, arg.length() - 1);
        }

        private Method getCurrentMethod(Method method, Class<?>[] classes, Method currentMethod) {
            try {
                currentMethod = myObject.getClass().getMethod(method.getName(), classes);
            } catch (NoSuchMethodException | SecurityException ignored) {
            }
            return currentMethod;
        }

        private Class<?>[] getClasses(Object[] args) {
            Class<?>[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
            return classes;
        }
    }


}
