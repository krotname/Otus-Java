package ru.otus.api;

import lombok.RequiredArgsConstructor;
import ru.otus.model.Bills;
import ru.otus.service.ClientService;

import java.util.Map;

@RequiredArgsConstructor
public class ClientApiImpl implements ClientApi {

    private final ClientService clientService;

    @Override
    public Map<Bills, Integer> withdrawal(int amount, int accountId) {

        return clientService.withdrawalCalculate(amount, accountId);
    }

    @Override
    public void depositing(Bills Bills, int amount, int accountId) {

    }
}
