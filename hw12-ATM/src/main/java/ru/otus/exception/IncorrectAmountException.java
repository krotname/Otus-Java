package ru.otus.exception;

public class IncorrectAmountException extends RuntimeException {
    public IncorrectAmountException() {
        super();
    }

    public IncorrectAmountException(String message) {
        super(message);
    }

    public IncorrectAmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectAmountException(Throwable cause) {
        super(cause);
    }
}
