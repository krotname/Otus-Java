package ru.otus;

import org.springframework.beans.factory.annotation.Value;
import ru.otus.Cache;

import java.util.*;

public class TimedWeakCache<K, V> implements Cache<K, V> {
    @Value("${app.size}")
    private int capacity;

    private final Map<K, TimedValue<V>> cache;

    public TimedWeakCache() {
        this.cache = Collections.synchronizedMap(new WeakHashMap<>());
    }

    @Override
    public boolean set(K key, V value) {
        cache.put(key, new TimedValue<>(value));
        return true;
    }

    @Override
    public Optional<V> get(K key) {
        TimedValue<V> timedValue = cache.get(key);
        if (timedValue == null || timedValue.isExpired()) {
            cache.remove(key);
            return Optional.empty();
        }
        return Optional.of(timedValue.getValue());
    }

    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public boolean isEmpty() {
        return cache.isEmpty();
    }

    @Override
    public void clear() {
        cache.clear();
    }


}