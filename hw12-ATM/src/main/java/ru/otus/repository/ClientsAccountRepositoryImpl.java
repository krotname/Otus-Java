package ru.otus.repository;

import java.util.HashMap;

public class ClientsAccountRepositoryImpl implements ClientsAccountRepository {

    private final HashMap<Integer, Integer> balances = new HashMap<>();

    @Override
    public void setBalance(int accountId, int balance){
        balances.putIfAbsent(accountId, balance);
    }
    @Override
    public int getBalance(int accountId){
        return balances.get(accountId);
    }

}
