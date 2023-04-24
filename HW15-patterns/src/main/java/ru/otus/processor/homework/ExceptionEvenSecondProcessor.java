package ru.otus.processor.homework;

import ru.otus.exception.EvenSecondException;
import ru.otus.model.Message;
import ru.otus.processor.Processor;

import java.time.LocalDateTime;

public class ExceptionEvenSecondProcessor implements Processor {

    private LocalDateTime time;

    public ExceptionEvenSecondProcessor(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public Message process(Message message) {
        if (time.getSecond() % 2 == 0) {
            throw new EvenSecondException();
        }
        return message;
    }
}
