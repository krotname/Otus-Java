package ru.otus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MedianNumList<T extends Number> {

    List<T> synchronizedList = Collections.synchronizedList(new ArrayList<T>());

    public int size() {

        return synchronizedList.size();
    }

    public void add(T item) {
        synchronizedList.add(item);
    }

    public void remove(T item) {
        synchronizedList.remove(item);
    }

    public Double getMedian() {
        List<T> sortedList = synchronizedList.stream().sorted().toList();
        int size = sortedList.size();
        if (size % 2 == 1) {
            T t = sortedList.get(size / 2);
            return t.doubleValue() ;
        } else {
            Number m1 = sortedList.get(size / 2 - 1);
            Number m2 = sortedList.get(size / 2);
            return (m1.doubleValue() + m2.doubleValue()) / 2;
        }
    }
}
