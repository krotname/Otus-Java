package ru.otus;

import ru.otus.api.ClientApiImpl;
import ru.otus.api.CollectorApiImpl;
import ru.otus.model.Bills;
import ru.otus.repository.MoneyBoxRepository;
import ru.otus.repository.MoneyBoxRepositoryImpl;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MoneyBoxRepository moneyBoxRepository = new MoneyBoxRepositoryImpl();

        CollectorApiImpl collectorApi = new CollectorApiImpl(moneyBoxRepository);
        ClientApiImpl clientApi = new ClientApiImpl(moneyBoxRepository);

        AtmInitializer atmInitializer = new AtmInitializer(collectorApi);

        atmInitializer.init(
                Map.of(Bills.RUB_5000, 100,
                        Bills.RUB_2000, 100,
                        Bills.RUB_1000, 100,
                        Bills.RUB_500, 100,
                        Bills.RUB_200, 100,
                        Bills.RUB_100, 100));

        Map<Bills, Integer> withdrawal = clientApi.withdrawal(7300);
        System.out.println(withdrawal);


        System.out.println("ATM Work!");
    }
}
