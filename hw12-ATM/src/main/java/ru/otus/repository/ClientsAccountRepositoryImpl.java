package ru.otus.repository;

import java.util.HashMap;

public class ClientsAccountRepositoryImpl implements ClientsAccountRepository {

    private final HashMap<Integer, Integer> balance = new HashMap<>();

    @Override
    public void setBalance(int accountId, int balance){

    }
    @Override
    public int getBalance(int accountId){
        return 0;
    }

}
