package ru.otus;

public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.action();
        System.out.println("Hello world!");
    }

    public void action() {

        TestLoggingInterface testLoggingInterface = Ioc.createTestLoggingInterface();
        testLoggingInterface.calculation(6);
        testLoggingInterface.calculation("6");
    }
}
