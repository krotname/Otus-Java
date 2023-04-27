package ru.otus;

import ru.otus.handler.ComplexProcessor;
import ru.otus.listener.ListenerPrinterConsole;
import ru.otus.listener.homework.HistoryListener;
import ru.otus.model.Message;
import ru.otus.processor.homework.ExceptionEvenSecondProcessor;
import ru.otus.processor.homework.ExchangeProcessor;
import ru.otus.processor.homework.TimeProvider;
import ru.otus.processor.homework.TimeProviderImpl;

import java.time.LocalDateTime;
import java.util.List;

public class HomeWork {


    public static final Message MESSAGE = new Message.Builder(1L)
            .field10("--10--")
            .field11("++11++")
            .field12("**12**")
            .build();

    public static void main(String[] args) {
        TimeProvider timeProvider = new TimeProviderImpl();
        var processors = List.of(new ExceptionEvenSecondProcessor(timeProvider),
                new ExchangeProcessor());

        var complexProcessor = new ComplexProcessor(processors, System.err::println);
        var listenerPrinter = new ListenerPrinterConsole();
        var historyListener = new HistoryListener();
        complexProcessor.addListener(listenerPrinter);
        complexProcessor.addListener(historyListener);

        var result = complexProcessor.handle(MESSAGE);
        System.out.println("result:" + result);

        complexProcessor.removeListener(listenerPrinter);
        complexProcessor.removeListener(historyListener);

    }
}
