package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MedianListTest {
    private MedianList<Integer> medianList;

    @BeforeEach
    void setUp() {
        medianList = new MedianList<>();
    }

    @Test
    void size() {
        assertEquals(0, medianList.size());
        medianList.add(Util.random.nextInt());
        assertEquals(1, medianList.size());

    }

    @Test
    void add() {
        assertEquals(0, medianList.size());
        for (int i = 0; i < Util.LIMIT; i++) {
            medianList.add(Util.random.nextInt());
        }
        assertEquals(Util.LIMIT, medianList.size());
    }

    @Test
    void remove() {
        assertEquals(0, medianList.size());
        medianList.add(1);
        medianList.add(2);
        assertEquals(2, medianList.size());
        medianList.remove(1);
        medianList.remove(2);
        assertEquals(0, medianList.size());
    }

    @Test
    void getMedianEven() {
        medianList.add(3);
        medianList.add(7);
        medianList.add(12);
        medianList.add(16);
        medianList.add(19);
        Integer median = medianList.getMedian();
        assertEquals(12, median);
    }

    @Test
    void getMedianOdd() {
        medianList.add(4);
        medianList.add(6);
        medianList.add(10);
        medianList.add(13);
        medianList.add(18);
        medianList.add(22);
        Integer median = medianList.getMedian();
        assertEquals(10, median);
    }

    @Test
    void getMedianPerformance() {
        assertEquals(0, medianList.size());
        for (int i = 0; i < Util.LIMIT; i++) {
            medianList.add(Util.random.nextInt());
        }
        Integer median = medianList.getMedian();
        assertNotEquals(0, median);
    }
}