package ru.otus;

import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;

public class WeakCache<K, V> implements Cache<K, V> {
    private final Map<K, V> cache;

    public WeakCache() {
        this.cache = new WeakHashMap<>();
    }

    @Override
    public synchronized boolean set(K key, V value) {
        cache.put(key, value);
        return true;
    }

    @Override
    public synchronized Optional<V> get(K key) {
        return Optional.ofNullable(cache.get(key));
    }

    @Override
    public synchronized int size() {
        return cache.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return cache.isEmpty();
    }

    @Override
    public synchronized void clear() {
        cache.clear();
    }
}