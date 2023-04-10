package ru.otus.repository;

public interface ClientsAccountRepository {
    void setBalance(int accountId, int balance);

    int getBalance(int accountId);
}
