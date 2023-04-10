package ru.otus.api;

import ru.otus.model.Bills;

import java.util.Map;

public class CollectorApiImpl implements CollectorApi {
    @Override
    public void replenishmentOfMoney(String collectorPassword, Map<Bills, Integer> bills){

    }

    @Override
    public Map<Bills, Integer> collectionOfMoney(String collectorPassword, int amount){
        return null;
    }

    @Override
    public void strikeBalance(String collectorPassword, int accountId, int balance){

    }
}
