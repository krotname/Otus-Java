package ru.otus.api;

import ru.otus.model.Bills;

import java.util.Map;

public interface ClientApi {
    Map<Bills, Integer> withdrawal(int amount, int accountId);

    void depositing(Bills Bills, int amount, int accountId);
}