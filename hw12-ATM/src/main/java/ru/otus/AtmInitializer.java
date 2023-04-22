package ru.otus;

import lombok.RequiredArgsConstructor;
import ru.otus.api.CollectorApi;
import ru.otus.model.Bills;

import java.util.Map;

@RequiredArgsConstructor
public class AtmInitializer {
    private final CollectorApi collectorApi;

    public void init(Map<Bills, Integer> rubs) {
        collectorApi.replenishmentOfMoney(rubs);
    }
}
