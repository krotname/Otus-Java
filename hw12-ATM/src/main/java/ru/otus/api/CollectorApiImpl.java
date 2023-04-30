package ru.otus.api;

import lombok.RequiredArgsConstructor;
import ru.otus.model.Bills;
import ru.otus.repository.MoneyBoxRepository;

import java.util.Map;

@RequiredArgsConstructor
public class CollectorApiImpl implements CollectorApi {

    private final MoneyBoxRepository moneyBoxRepository;

    @Override
    public void replenishmentOfMoney(Map<Bills, Integer> bills) {
        bills.forEach((moneyBoxRepository::addBill));
    }

    @Override
    public Map<Bills, Integer> collectionOfMoney(String collectorPassword, int amount) {
        return null;
    }

    @Override
    public void strikeBalance(String collectorPassword, int accountId, int balance) {

    }
}
