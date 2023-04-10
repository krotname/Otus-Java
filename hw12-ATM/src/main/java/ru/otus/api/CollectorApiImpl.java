package ru.otus.api;

import lombok.RequiredArgsConstructor;
import ru.otus.model.Bills;
import ru.otus.service.CollectorService;

import java.util.Map;

@RequiredArgsConstructor
public class CollectorApiImpl implements CollectorApi {

    private final CollectorService collectorService;

    @Override
    public void replenishmentOfMoney(String collectorPassword, Map<Bills, Integer> bills) {
        collectorService.replenishmentOfMoney(collectorPassword, bills);
    }

    @Override
    public Map<Bills, Integer> collectionOfMoney(String collectorPassword, int amount) {
        return null;
    }

    @Override
    public void strikeBalance(String collectorPassword, int accountId, int balance) {

    }
}
