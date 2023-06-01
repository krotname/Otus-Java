package ru.otus.exception;

public class NoMoneyException extends RuntimeException {
    public NoMoneyException() {
        super();
    }

    public NoMoneyException(String message) {
        super(message);
    }

    public NoMoneyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMoneyException(Throwable cause) {
        super(cause);
    }
}
