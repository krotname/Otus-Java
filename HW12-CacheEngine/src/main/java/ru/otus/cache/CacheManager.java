package ru.otus.cache;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CacheManager<V> {

    private final ConcurrentHashMap<Long, SoftReference<V>> cache = new ConcurrentHashMap<>();
    private final DelayQueue<ExpiringKey> cleaningUpQueue = new DelayQueue<>();

    public CacheManager() {
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

    public void put(Long key, V value) {
       put(key, value, 10, TimeUnit.MINUTES);
    }
    public void put(Long key, V value, long period, TimeUnit unit) {
        if (key == null || value == null) {
            log.warn("key = " + key);
            log.warn("value = " + value);
            throw new IllegalArgumentException("Key or value is null");
        }

        if (cache.containsKey(key)) {
            // Remove the old key
            remove(key);
        }

        SoftReference<V> reference = new SoftReference<>(value);
        cache.put(key, reference);
        long expiryTime = System.currentTimeMillis() + unit.toMillis(period);
        cleaningUpQueue.put(new ExpiringKey(key, reference, expiryTime));
    }

    public V get(Long key) {
        SoftReference<V> reference = cache.get(key);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    public void remove(Long key) {
        SoftReference<V> reference = cache.remove(key);
        if (reference != null) {
            cleaningUpQueue.remove(new ExpiringKey(key, reference, 0));
        }
    }

    public void clear() {
        // Be aware of the potential for memory consistency errors
        // as this is a non-atomic operation on the underlying map
        for (Long key : cache.keySet()) {
            remove(key);
        }
    }

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

        // It's necessary to override equals to ensure proper removal from the DelayQueue
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
