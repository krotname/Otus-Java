package ru.otus;

import org.springframework.beans.factory.annotation.Value;

public class TimedValue<T> {

    private final long timestamp;
    private final T value;
    @Value("${app.time}")
    private long lifetime = 10000;

    public TimedValue(T value) {
        this.timestamp = System.currentTimeMillis();
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - timestamp > lifetime;
    }
}