package ru.otus;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testAnnotationProcessor() {
        Entity entity = new Entity();
        entity.setString("ABC");
//        String result=CustomToString.toString(entity);
        System.out.println(entity);
    }
}