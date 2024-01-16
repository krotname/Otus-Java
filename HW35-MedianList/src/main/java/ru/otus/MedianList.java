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
            // Если размер массива четный, нужно найти два центральных элемента
            T median1 = medianOfMedians(synchronizedList, k);
            T median2 = medianOfMedians(synchronizedList, k - 1);
            // Возвращаем среднее значение двух центральных элементов
            return getAverage(median1, median2);
        } else {
            // Если размер массива нечетный, нужно найти один центральный элемент
            return medianOfMedians(synchronizedList, k);
        }
    }

    private T getAverage(T a, T b) {
        // Возвращает среднее значение двух элементов, предполагая, что T extends Comparable<T>
        if (a.compareTo(b) == 0) {
            return a;  // a и b равны, возвращаем любой из них
        } else {
            return a.compareTo(b) < 0 ? a : b;  // Возвращаем меньший из двух элементов
        }
    }

    private T medianOfMedians(List<T> nums, int k) {
        int chunkSize = 5;

        if (nums.size() <= chunkSize) {
            // Если размер массива не превышает chunkSize, можно сразу отсортировать
            Collections.sort(nums);
            return nums.get(k);
        }

        // Разделение на группы по chunkSize элементов
        ArrayList<T> medians = new ArrayList<>();
        for (int i = 0; i < nums.size(); i += chunkSize) {
            int endIndex = Math.min(i + chunkSize, nums.size());
            ArrayList<T> chunk = new ArrayList<>(nums.subList(i, endIndex));
            Collections.sort(chunk);
            medians.add(chunk.get(chunk.size() / 2));
        }

        // Рекурсивный вызов для поиска медианы медиан
        T pivot = medianOfMedians(medians, medians.size() / 2);

        // Разделение массива на элементы, меньшие, равные и большие чем pivot
        ArrayList<T> lower = new ArrayList<>();
        ArrayList<T> equal = new ArrayList<>();
        ArrayList<T> greater = new ArrayList<>();

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
