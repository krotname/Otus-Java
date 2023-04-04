package org.example.tests;

import org.example.anotation.After;
import org.example.anotation.Before;
import org.example.anotation.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test2 {

    private List<Integer> linkedList;

    @Before
    public void before() {
        linkedList = new LinkedList<>();
    }

    @Test
    public void test1() {
        System.out.println(linkedList.size());
    }

    @Test
    public void test2() {
        List list = null;
        System.out.println(list.size());
    }

    @Test
    public void test3() {
        List list = null;
        System.out.println(list.size());
    }

    @After
    public void after() {
        System.out.println("after");
    }


}
