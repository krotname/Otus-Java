package ru.otus.repository;

import ru.otus.model.Bills;

public interface MoneyBoxRepository {
    void addBill(Bills bill, int quantity);

    boolean checkBill(Bills bill, int quantity);

    int withdrawBanknote(Bills bill, int quantity);
}
