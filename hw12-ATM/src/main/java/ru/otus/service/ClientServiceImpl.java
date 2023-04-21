package ru.otus.service;

import lombok.RequiredArgsConstructor;
import ru.otus.exception.IncorrectAmountException;
import ru.otus.model.Bills;
import ru.otus.repository.MoneyBoxRepository;

import java.util.Map;

import static ru.otus.model.Bills.*;

@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final MoneyBoxRepository moneyBoxRepository;

    @Override
    public Map<Bills, Integer> withdrawalCalculate(int amount, int accountId) {
        if (amount % 100 != 0) throw new IncorrectAmountException();
        int remainder5000 = amount % 5000;
        int count5000 = amount / 5000;
        int remainder2000 = remainder5000 % 2000;
        int count2000 = remainder5000 / 2000;
        int remainder1000 = remainder2000 % 1000;
        int count1000 = remainder2000 / 1000;
        int remainder500 = remainder1000 % 500;
        int count500 = remainder1000 / 500;
        int remainder200 = remainder500 % 200;
        int count200 = remainder500 / 200;
        int count100 = remainder200 / 100;

        return Map.of(RUB_5000, moneyBoxRepository.withdrawBanknote(RUB_5000, count5000),
                RUB_2000, moneyBoxRepository.withdrawBanknote(RUB_2000, count2000),
                RUB_1000, moneyBoxRepository.withdrawBanknote(RUB_1000, count1000),
                RUB_500, moneyBoxRepository.withdrawBanknote(RUB_500, count500),
                RUB_200, moneyBoxRepository.withdrawBanknote(RUB_200, count200),
                RUB_100, moneyBoxRepository.withdrawBanknote(RUB_100, count100)
        );
    }

    @Override
    public void depositing(Bills bill, int quantity) {
        moneyBoxRepository.addBill(bill, quantity);
    }

}
