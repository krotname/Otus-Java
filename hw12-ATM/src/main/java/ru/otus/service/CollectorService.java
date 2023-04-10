package ru.otus.service;

import ru.otus.model.Bills;

import java.util.Map;

public interface CollectorService {
    void replenishmentOfMoney(String collectorPassword, Map<Bills, Integer> bills);

    Map<Bills, Integer> collectionOfMoney(String collectorPassword, int amount);

    void strikeBalance(String collectorPassword, int accountId, int balance);
}
