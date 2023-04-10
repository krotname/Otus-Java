package ru.otus;

import ru.otus.api.ClientApiImpl;
import ru.otus.api.CollectorApiImpl;
import ru.otus.model.Bills;
import ru.otus.repository.ClientsAccountRepository;
import ru.otus.repository.ClientsAccountRepositoryImpl;
import ru.otus.repository.MoneyBoxRepository;
import ru.otus.repository.MoneyBoxRepositoryImpl;
import ru.otus.service.ClientServiceImpl;
import ru.otus.service.CollectorService;
import ru.otus.service.CollectorServiceImpl;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MoneyBoxRepository moneyBoxRepository = new MoneyBoxRepositoryImpl();
        ClientsAccountRepository clientsAccountRepository = new ClientsAccountRepositoryImpl();

        CollectorService collectorService = new CollectorServiceImpl(moneyBoxRepository);
        ClientServiceImpl clientService = new ClientServiceImpl(moneyBoxRepository);

        CollectorApiImpl collectorApi = new CollectorApiImpl(collectorService);
        ClientApiImpl clientApi = new ClientApiImpl(clientService);

        AtmInitializer atmInitializer = new AtmInitializer(collectorApi);

        atmInitializer.init();

        Map<Bills, Integer> withdrawal = clientApi.withdrawal(7300, 10);
        System.out.println(withdrawal);


        System.out.println("ATM Work!");
    }
}
