package ru.otus;

import java.util.Comparator;
import java.util.stream.IntStream;

public class TestLogging implements TestLoggingInterface {

    @Override
    @Log
    public void calculation(Integer i) {
        IntStream.rangeClosed(0, i).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println();
    }

    @Override
    public void calculation(String i) {
        System.out.println(i + i);
    }
}
