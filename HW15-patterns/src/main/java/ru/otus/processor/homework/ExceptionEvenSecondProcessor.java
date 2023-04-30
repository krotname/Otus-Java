package ru.otus.processor.homework;

import ru.otus.exception.EvenSecondException;
import ru.otus.model.Message;
import ru.otus.processor.Processor;

import java.time.LocalDateTime;

public class ExceptionEvenSecondProcessor implements Processor {

    private TimeProvider timeProvider;

    public ExceptionEvenSecondProcessor(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    @Override
    public Message process(Message message) {
        int seconds = timeProvider.getLocalDateTime().getSecond();
        if (seconds % 2 == 0) {
            throw new EvenSecondException();
        }
        return message;
    }
}
