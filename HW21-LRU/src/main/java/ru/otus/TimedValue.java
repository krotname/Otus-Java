package ru.otus;

import org.springframework.beans.factory.annotation.Value;

public class TimedValue<T> {

    @Value("${app.time}")
    private long lifetime;
    private final long timestamp;
    private final T value;

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