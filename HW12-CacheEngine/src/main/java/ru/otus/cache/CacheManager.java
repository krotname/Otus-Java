package ru.otus.cache;

import java.util.concurrent.TimeUnit;

public interface CacheManager<V> {
    void put(Long key, V value);

    void put(Long key, V value, long period, TimeUnit unit);

    V get(Long key);

    void remove(Long key);

    void clear();

    long size();
}
