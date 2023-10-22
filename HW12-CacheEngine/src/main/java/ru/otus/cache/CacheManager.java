package ru.otus.cache;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.WeakHashMap;

@Slf4j
public class CacheManager <T> {
    private final Map<Long, T> cache = new WeakHashMap<>();

    public T get(Long id){
        return cache.get(id);
    };

    public T put(Long id, T obj){
        return cache.put(id, obj);
    }

}
