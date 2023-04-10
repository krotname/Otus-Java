package ru.otus.repository;

import ru.otus.model.Bills;

import java.util.HashMap;

public class MoneyBoxRepositoryImpl implements MoneyBoxRepository {

    private final HashMap<Bills, Integer> repository = new HashMap<>();

    @Override
    public void addBill(Bills bill, int quantity) {

    }

    @Override
    public boolean checkBill(Bills bill, int quantity) {
        return true;
    }

    @Override
    public int withdrawBanknote(Bills bill, int quantity){
        return 0;
    }

}
