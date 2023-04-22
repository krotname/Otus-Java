package ru.otus.processor;

import ru.otus.exception.EvenSecondException;
import ru.otus.model.Message;

import java.time.LocalDateTime;

public class ExceptionEvenSecondProcessor implements Processor {

    private final LocalDateTime localDateTime;

    public ExceptionEvenSecondProcessor(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public Message process(Message message) {
        if (localDateTime.getSecond() % 2 == 0) {
            throw new EvenSecondException();
        }
        return message;
    }
}
