package ru.otus.cache;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CacheManagerImpl<V> implements CacheManager<V> {

    private final ConcurrentHashMap<Long, SoftReference<V>> cache = new ConcurrentHashMap<>();
    private final DelayQueue<ExpiringKey> cleaningUpQueue = new DelayQueue<>();

    public CacheManagerImpl() {
        Thread cleanerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    ExpiringKey delayedCacheKey = cleaningUpQueue.take();
                    cache.remove(delayedCacheKey.getKey(), delayedCacheKey.getReference());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        cleanerThread.setDaemon(true);
        cleanerThread.start();
    }

    @Override
    public void put(Long key, V value) {
        put(key, value, 10, TimeUnit.MINUTES);
    }

    @Override
    public void put(Long key, V value, long period, TimeUnit unit) {
        if (key == null || value == null) {
            log.warn("key = " + key);
            log.warn("value = " + value);
            throw new IllegalArgumentException("Key or value is null");
        }

        if (cache.containsKey(key)) {
            remove(key);
        }

        SoftReference<V> reference = new SoftReference<>(value);
        cache.put(key, reference);
        long expiryTime = System.currentTimeMillis() + unit.toMillis(period);
        cleaningUpQueue.put(new ExpiringKey(key, reference, expiryTime));
    }

    @Override
    public V get(Long key) {
        SoftReference<V> reference = cache.get(key);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override
    public void remove(Long key) {
        SoftReference<V> reference = cache.remove(key);
        if (reference != null) {
            cleaningUpQueue.remove(new ExpiringKey(key, reference, 0));
        }
    }

    @Override
    public void clear() {
        for (Long key : cache.keySet()) {
            remove(key);
        }
    }

    @Override
    public long size() {
        return cache.entrySet().stream().filter(entry -> entry.getValue().get() != null).count();
    }

    private static class ExpiringKey<K, V> implements Delayed {
        private final Long key;
        private final SoftReference<V> reference;
        private final long expiryTime;

        public ExpiringKey(Long key, SoftReference<V> reference, long expiryTime) {
            this.key = key;
            this.reference = reference;
            this.expiryTime = expiryTime;
        }

        public Long getKey() {
            return key;
        }

        public SoftReference<V> getReference() {
            return reference;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(expiryTime, ((ExpiringKey<?, ?>) o).expiryTime);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            ExpiringKey<?, ?> that = (ExpiringKey<?, ?>) obj;
            return key.equals(that.key) &&
                    reference.get().equals(that.reference.get());
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }
}
