package ru.otus.api;

import lombok.RequiredArgsConstructor;
import ru.otus.exception.IncorrectAmountException;
import ru.otus.model.Bills;
import ru.otus.repository.MoneyBoxRepository;

import java.util.Map;

import static ru.otus.model.Bills.*;

@RequiredArgsConstructor
public class ClientApiImpl implements ClientApi {

    private final MoneyBoxRepository moneyBoxRepository;

    @Override
    public Map<Bills, Integer> withdrawal(int amount) {
        if (amount % RUB_100.getPar() != Bills.ZERO) throw new IncorrectAmountException();
        int remainder5000 = amount % RUB_5000.getPar();
        int count5000 = amount / RUB_5000.getPar();
        int remainder2000 = remainder5000 % RUB_2000.getPar();
        int count2000 = remainder5000 / RUB_2000.getPar();
        int remainder1000 = remainder2000 % RUB_1000.getPar();
        int count1000 = remainder2000 / RUB_1000.getPar();
        int remainder500 = remainder1000 % RUB_500.getPar();
        int count500 = remainder1000 / RUB_500.getPar();
        int remainder200 = remainder500 % RUB_200.getPar();
        int count200 = remainder500 / RUB_200.getPar();
        int count100 = remainder200 / RUB_100.getPar();

        return Map.of(RUB_5000, moneyBoxRepository.withdrawBanknote(RUB_5000, count5000),
                RUB_2000, moneyBoxRepository.withdrawBanknote(RUB_2000, count2000),
                RUB_1000, moneyBoxRepository.withdrawBanknote(RUB_1000, count1000),
                RUB_500, moneyBoxRepository.withdrawBanknote(RUB_500, count500),
                RUB_200, moneyBoxRepository.withdrawBanknote(RUB_200, count200),
                RUB_100, moneyBoxRepository.withdrawBanknote(RUB_100, count100)
        );
    }

    @Override
    public void depositing(Bills bill, int amount) {
        moneyBoxRepository.addBill(bill, amount);
    }
}
