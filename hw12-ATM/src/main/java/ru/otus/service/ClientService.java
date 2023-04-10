package ru.otus.service;

import ru.otus.model.Bills;

import java.util.Map;

public interface ClientService {
    Map<Bills, Integer> withdrawalCalculate(int amount, int accountId);

    void depositing(Bills bill, int quantity);
}
