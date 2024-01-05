package ru.otus;

import java.lang.reflect.Method;


public class MethodWithClasses {
    private Method method;
    private Class<?>[] classes;

    public MethodWithClasses(Method method, Class<?>[] classes) {
        this.method = method;
        this.classes = classes;
    }

    private MethodWithClasses() {
    }

    public static MethodWithClasses of(Method method, Class<?>[] classes) {
        return new MethodWithClasses(method, classes);
    }

    public Method getMethod() {
        return method;
    }

    public Class<?>[] getClasses() {
        return classes;
    }
}
