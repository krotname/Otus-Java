package ru.otus;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class TimedWeakCache<K, V> implements Cache<K, V> {
    private final ConcurrentHashMap<WeakReference<K>, TimedValue<V>> cache;

    public TimedWeakCache() {
        this.cache = new ConcurrentHashMap<>();
    }

    @Override
    public boolean set(K key, V value) {
        cleanExpiredEntries();
        cache.put(new WeakReference<>(key), new TimedValue<>(value));
        return true;
    }

    @Override
    public Optional<V> get(K key) {
        cleanExpiredEntries();
        WeakReference<K> weakKey = new WeakReference<>(key);
        TimedValue<V> timedValue = cache.entrySet()
                .stream()
                .filter(e -> Objects.equals(key, e.getKey().get()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);

        if (timedValue == null || timedValue.isExpired()) {
            cache.remove(weakKey);
            return Optional.empty();
        }
        return Optional.of(timedValue.getValue());
    }

    @Override
    public int size() {
        cleanExpiredEntries();
        return cache.size();
    }

    @Override
    public boolean isEmpty() {
        cleanExpiredEntries();
        return cache.isEmpty();
    }

    @Override
    public void clear() {
        cache.clear();
    }

    private void cleanExpiredEntries() {
        cache.entrySet().removeIf(entry -> entry.getKey().get() == null || entry.getValue().isExpired());
    }
}
