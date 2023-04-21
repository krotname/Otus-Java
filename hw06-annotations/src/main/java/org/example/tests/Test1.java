package org.example.tests;

import org.example.anotation.After;
import org.example.anotation.Before;
import org.example.anotation.Test;

public class Test1 {
    @Before
    public void before() {
        System.out.println("Hello Before!");

    }

    @Test
    public void test1() {
        System.out.println("Hello tests 1!");
    }

    @Test
    public void test2() {
        throw new RuntimeException();
    }

    @Test
    public void test3() {
        System.out.println("Hello tests 3!");
    }

    @After
    public void after() {
        System.out.println("Hello After!");
    }

}
