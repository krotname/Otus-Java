package ru.otus.servlet;

public interface UserAuthService {
    boolean authenticate(String login, String password);
}
