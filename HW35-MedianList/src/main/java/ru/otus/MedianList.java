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
        int k = size / 2;

        if (size % 2 == 0) {
            T median1 = medianOfMedians(synchronizedList, k);
            T median2 = medianOfMedians(synchronizedList, k - 1);
            return getAverage(median1, median2);
        } else {
            return medianOfMedians(synchronizedList, k);
        }
    }

    private T getAverage(T a, T b) {
        if (a.compareTo(b) == 0) {
            return a;
        } else {
            return a.compareTo(b) < 0 ? a : b;
        }
    }

    private T medianOfMedians(List<T> nums, int k) {
        int chunkSize = 5;

        if (nums.size() <= chunkSize) {
            Collections.sort(nums);
            return nums.get(k);
        }

        List<T> medians = new ArrayList<>();
        for (int i = 0; i < nums.size(); i += chunkSize) {
            int endIndex = Math.min(i + chunkSize, nums.size());
            List<T> chunk = new ArrayList<>(nums.subList(i, endIndex));
            Collections.sort(chunk);
            medians.add(chunk.get(chunk.size() / 2));
        }

        T pivot = medianOfMedians(medians, medians.size() / 2);

        List<T> lower = new ArrayList<>();
        List<T> equal = new ArrayList<>();
        List<T> greater = new ArrayList<>();

        for (T element : nums) {
            int comparisonResult = element.compareTo(pivot);
            if (comparisonResult < 0) {
                lower.add(element);
            } else if (comparisonResult == 0) {
                equal.add(element);
            } else {
                greater.add(element);
            }
        }

        if (k < lower.size()) {
            return medianOfMedians(lower, k);
        } else if (k < lower.size() + equal.size()) {
            return pivot;
        } else {
            return medianOfMedians(greater, k - lower.size() - equal.size());
        }
    }
}
