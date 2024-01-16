package ru.otus;

import java.util.*;

public final class MedianList<T extends Comparable<T>> {

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


    public T getMedian() {
        int size = synchronizedList.size();
        if (size % 2 == 1) {
            return synchronizedList.get(size / 2);
        } else {
            T m1 = synchronizedList.get(size / 2 - 1);
            T m2 = synchronizedList.get(size / 2);
            int compare = Objects.compare(m1, m2, Comparator.naturalOrder());
            return compare < 0 ? m1 : m2;
        }
    }
}
