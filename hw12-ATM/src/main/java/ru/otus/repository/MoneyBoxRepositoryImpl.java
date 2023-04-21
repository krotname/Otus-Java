package ru.otus.repository;

import ru.otus.model.Bills;

import java.util.HashMap;

public class MoneyBoxRepositoryImpl implements MoneyBoxRepository {

    private final HashMap<Bills, Integer> repository = new HashMap<>();

    @Override
    public void addBill(Bills bill, int quantity) {
        repository.putIfAbsent(bill, quantity);
    }

    @Override
    public boolean checkBill(Bills bill, int quantity) {
        return repository.get(bill) >= quantity;
    }

    @Override
    public int withdrawBanknote(Bills bill, int quantity) {
        repository.computeIfPresent(bill, (b, amount) -> amount - quantity);
        return quantity;
    }

}
