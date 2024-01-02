package ru.otus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToStringsTest {
    @Test
    public void whenCallToStrings_thenWorks() {
        Cat cat = new Cat();
        cat.setName("Vasya");
        cat.setBreed("besporody");
        String result = ru.otus.ToStrings.toString(cat);
        System.out.println(result);
        System.out.println(cat);
        assertEquals(2, result.split(",").length);
    }
}
