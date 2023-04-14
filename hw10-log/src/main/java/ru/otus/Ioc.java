package ru.otus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

class Ioc {

    private Ioc() {
    }

    static TestLoggingInterface createTestLoggingInterface() {
        InvocationHandler handler = new LogInvocationHandler(new TestLogging());
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
            Class<?>[] classes = getClasses(args);

            Method currentMethod = null;
            try {
                currentMethod = myObject.getClass().getMethod(method.getName(), classes);
            } catch (NoSuchMethodException | SecurityException ignored) {
            }

            if (currentMethod != null && currentMethod.isAnnotationPresent(Log.class)) {
                String arg = Arrays.toString(args);
                System.out.println("executed method: " + method.getName() + ", param: " + arg.substring(1, arg.length() - 1));
            }
            return method.invoke(myObject, args);
        }
    }

    private static Class<?>[] getClasses(Object[] args) {
        Class<?>[] classes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            classes[i] = args[i].getClass();
        }
        return classes;
    }
}
