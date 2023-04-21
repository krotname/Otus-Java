package ru.otus.service;

import lombok.RequiredArgsConstructor;
import ru.otus.exception.IncorrectPasswordException;
import ru.otus.model.Bills;
import ru.otus.repository.MoneyBoxRepository;

import java.util.Map;

@RequiredArgsConstructor
public class CollectorServiceImpl implements CollectorService {
    private static final String PASSWORD = "9988";
    private final MoneyBoxRepository moneyBoxRepository;

    private static void validPassword(String collectorPassword) {
        if (!PASSWORD.equals(collectorPassword)) throw new IncorrectPasswordException("Не верный пароль инкассатора");
    }

    @Override
    public void replenishmentOfMoney(String collectorPassword, Map<Bills, Integer> bills) {
        validPassword(collectorPassword);
        bills.forEach((moneyBoxRepository::addBill));
    }

    @Override
    public Map<Bills, Integer> collectionOfMoney(String collectorPassword, int amount) {
        validPassword(collectorPassword);

        return null;
    }

    @Override
    public void strikeBalance(String collectorPassword, int accountId, int balance) {
        validPassword(collectorPassword);
    }

}
