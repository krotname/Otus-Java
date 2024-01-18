package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcurrentLinkedQueueTest {

    private ConcurrentLinkedQueue<Integer> concurrentLinkedQueue;

    @BeforeEach
    void setUp() {
        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    }

    @Test
    void size() {
        assertEquals(0, concurrentLinkedQueue.size());
        concurrentLinkedQueue.add(Util.random.nextInt());
        assertEquals(1, concurrentLinkedQueue.size());

    }

    @Test
    void add() {
        assertEquals(0, concurrentLinkedQueue.size());
        for (int i = 0; i < Util.LIMIT; i++) {
            concurrentLinkedQueue.add(Util.random.nextInt());
        }
        assertEquals(Util.LIMIT, concurrentLinkedQueue.size());
    }

    @Test
    void remove() {
        assertEquals(0, concurrentLinkedQueue.size());
        concurrentLinkedQueue.add(1);
        concurrentLinkedQueue.add(2);
        assertEquals(2, concurrentLinkedQueue.size());
        concurrentLinkedQueue.remove(1);
        concurrentLinkedQueue.remove(2);
        assertEquals(0, concurrentLinkedQueue.size());

    }
}