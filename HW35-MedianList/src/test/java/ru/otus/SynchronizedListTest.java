package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SynchronizedListTest {
    List<Integer> synchronizedList;


    @BeforeEach
    void setUp() {
        synchronizedList = Collections.synchronizedList(new ArrayList<>());
    }

    @Test
    void size() {
        assertEquals(0, synchronizedList.size());
        synchronizedList.add(Util.random.nextInt());
        assertEquals(1, synchronizedList.size());

    }

    @Test
    void add() {
        assertEquals(0, synchronizedList.size());
        for (int i = 0; i < Util.LIMIT; i++) {
            synchronizedList.add(Util.random.nextInt());
        }
        assertEquals(Util.LIMIT, synchronizedList.size());
    }

    @Test
    void remove() {
        assertEquals(0, synchronizedList.size());
        synchronizedList.add(0);
        synchronizedList.add(1);
        assertEquals(2, synchronizedList.size());
        synchronizedList.remove(1);
        synchronizedList.remove(0);
        assertEquals(0, synchronizedList.size());

    }
}
