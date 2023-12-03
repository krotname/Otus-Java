package ru.otus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersistentCache<K, V> implements Cache<K, V> {
    private final File file;
    private Map<K, V> cache;
    private final ObjectMapper mapper;

    public PersistentCache(File file) throws IOException {
        this.file = file;
        this.mapper = new ObjectMapper();
        if (file.exists()) {
            TypeReference<HashMap<K,V>> typeRef = new TypeReference<HashMap<K,V>>() {};
            cache = mapper.readValue(file, typeRef);
        } else {
            cache = new HashMap<>();
        }
    }

    @Override
    public synchronized boolean set(K key, V value) {
        cache.put(key, value);
        save();
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
        save();
    }

    private void save() {
        try {
            mapper.writeValue(file, cache);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save cache", e);
        }
    }
}