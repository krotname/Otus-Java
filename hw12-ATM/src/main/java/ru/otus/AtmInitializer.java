package ru.otus;

import lombok.RequiredArgsConstructor;
import ru.otus.api.CollectorApi;
import ru.otus.model.Bills;

import java.util.Map;

@RequiredArgsConstructor
public class AtmInitializer {

    private final CollectorApi collectorApi;

    public void init() {
        Map<Bills, Integer> rubs = Map.of(Bills.RUB_5000, 100,
                Bills.RUB_2000, 100,
                Bills.RUB_1000, 100,
                Bills.RUB_500, 100,
                Bills.RUB_200, 100,
                Bills.RUB_100, 100);

        collectorApi.replenishmentOfMoney("9988", rubs);
    }
}
