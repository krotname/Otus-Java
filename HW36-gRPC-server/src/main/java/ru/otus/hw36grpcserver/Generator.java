package ru.otus.hw36grpcserver;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class Generator {

    private static final long FIRST_VALUE = 0;
    private static final long LAST_VALUE = 8;
    private long currentValue;

    public Generator() {
        currentValue = FIRST_VALUE;
    }

    @SneakyThrows
    public long generate() {
        if (currentValue < LAST_VALUE) {
            return currentValue++;
        } else {
            return LAST_VALUE;
        }
    }
}
