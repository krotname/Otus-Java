package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianNumListTest {
    private MedianNumList<Integer> medianNumList;

    @BeforeEach
    void setUp() {
        medianNumList = new MedianNumList<>();
    }

    @Test
    void size() {
        assertEquals(0, medianNumList.size());
        medianNumList.add(Util.random.nextInt());
        assertEquals(1, medianNumList.size());

    }

    @Test
    void add() {
        assertEquals(0, medianNumList.size());
        for (int i = 0; i < Util.LIMIT; i++) {
            medianNumList.add(Util.random.nextInt());
        }
        assertEquals(Util.LIMIT, medianNumList.size());
    }

    @Test
    void remove() {
        assertEquals(0, medianNumList.size());
        medianNumList.add(1);
        medianNumList.add(2);
        assertEquals(2, medianNumList.size());
        medianNumList.remove(1);
        medianNumList.remove(2);
        assertEquals(0, medianNumList.size());
    }

    @Test
    void getMedianEven() {
        medianNumList.add(3);
        medianNumList.add(7);
        medianNumList.add(12);
        medianNumList.add(16);
        medianNumList.add(19);
        Double median = medianNumList.getMedian();
        assertEquals(12L, median);
    }

    @Test
    void getMedianOdd() {
        medianNumList.add(4);
        medianNumList.add(6);
        medianNumList.add(10);
        medianNumList.add(13);
        medianNumList.add(18);
        medianNumList.add(22);
        Double median = medianNumList.getMedian();
        assertEquals(11.5, median);
    }
}