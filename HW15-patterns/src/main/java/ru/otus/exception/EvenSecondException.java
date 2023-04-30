package ru.otus.exception;

public class EvenSecondException extends RuntimeException {
    public EvenSecondException() {
        super("Сейчас чётная секунда");
    }

    public EvenSecondException(String message) {
        super(message);
    }

    public EvenSecondException(String message, Throwable cause) {
        super(message, cause);
    }

    public EvenSecondException(Throwable cause) {
        super(cause);
    }
}
