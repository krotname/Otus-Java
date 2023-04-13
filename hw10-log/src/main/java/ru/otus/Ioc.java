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
        private final TestLoggingInterface myClass;

        private LogInvocationHandler(TestLoggingInterface myClass) {
            this.myClass = myClass;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            for (Method currentMethod : myClass.getClass().getMethods()) {
                if (currentMethod.isAnnotationPresent(Log.class)
                        && currentMethod.getName().equals(method.getName())
                        && Arrays.equals(currentMethod.getParameterTypes(), method.getParameterTypes())) {
                    String arg = Arrays.toString(args);
                    System.out.println("executed method: " + method.getName() + ", param: " + arg.substring(1, arg.length() - 1));
                }
            }
            return method.invoke(myClass, args);
        }
    }
}
