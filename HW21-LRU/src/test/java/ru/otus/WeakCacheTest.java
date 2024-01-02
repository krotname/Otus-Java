package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class WeakCacheTest {

    private Cache<String, String> cache;

    @BeforeEach
    public void setUp() {
        cache = new WeakCache<>();
    }

    @Test
    public void testConcurrency() throws InterruptedException {
        int threadCount = 100;
        ExecutorService service = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            int finalI = i;
            service.submit(() -> {
                cache.set("key" + finalI, "value" + finalI);
            });
        }

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);

        for (int i = 0; i < threadCount; i++) {
            Optional<String> value = cache.get("key" + i);
            assertTrue(value.isPresent());
            assertEquals("value" + i, value.get());
        }
    }


    @Test
    public void testSetAndGet() {
        cache.set("key1", "value1");
        Optional<String> value = cache.get("key1");
        assertTrue(value.isPresent());
        assertEquals("value1", value.get());
    }

    @Test
    public void testSize() {
        cache.set("key1", "value1");
        cache.set("key2", "value2");
        assertEquals(2, cache.size());
    }

    @Test
    public void testIsEmpty() {
        cache.clear();
        assertTrue(cache.isEmpty());
        cache.set("key1", "value1");
        assertFalse(cache.isEmpty());
    }

    @Test
    public void testClear() {
        cache.set("key1", "value1");
        cache.clear();
        assertTrue(cache.isEmpty());
    }
}