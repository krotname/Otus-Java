package org.example;

import org.example.anotation.After;
import org.example.anotation.Before;
import org.example.anotation.Test;
import org.example.tests.Test1;
import org.example.tests.Test2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class RunTests {

    public static final String RED = "\033[31m";
    public static final String BLACK = "\033[0m";



    public void run(final Class<?> clazz) {
        List<Method> previous = getMetordList(clazz, Before.class);
        List<Method> afters = getMetordList(clazz, After.class);
        process(clazz, previous, afters);
    }

    private void process(final Class<?> clazz, final List<Method> previous, final List<Method> afters) {

        int successful = 0;
        int failed = 0;
        for (Method testMethod : clazz.getDeclaredMethods()) {
            if (testMethod.isAnnotationPresent(Test.class)) {
                testMethod.setAccessible(true);
                Object test = getObject(clazz);
                if (test == null) return;
                executeList(previous, test);
                try {
                    testMethod.invoke(test);
                    successful++;
                } catch (Exception e) {
                    printError(e);
                    failed++;
                }
                executeList(afters, test);
            }
        }
        printStats(successful, failed);
    }

    private void executeList(final List<Method> previous, final Object test) {
        for (Method m : previous) {
            try {
                m.invoke(test);

            } catch (Exception e) {
                printError(e);
            }
        }
    }

    private Object getObject(final Class<?> clazz) {
        Object test = null;
        try {
            test = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            printError(e);
            return null;
        }
        return test;
    }

    private void printStats(final int successful, final int failed) {
        System.out.println();
        System.out.println("successful = " + successful);
        System.out.println("failed = " + RED + failed + BLACK);
        System.out.println();
    }

    private void printError(final Exception e) {
        System.out.println(RED + e.getCause() + BLACK);
    }

    private List<Method> getMetordList(final Class<?> clazz, final Class annotationType) {
        List<Method> previous = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotationType)) {
                method.setAccessible(true);
                previous.add(method);
            }
        }
        return previous;
    }
}
