package ru.otus.processor;

import org.junit.jupiter.api.Test;
import ru.otus.exception.EvenSecondException;
import ru.otus.processor.homework.ExceptionEvenSecondProcessor;
import ru.otus.processor.homework.TimeProvider;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.otus.processor.MockMessage.ORIGINAL_MESSAGE;

class ExceptionEvenSecondProcessorTest {

    private static final TimeProvider EVEN_SECOND = () -> LocalDateTime.
            ofEpochSecond(1682202442, 0, ZoneOffset.UTC);// Sat, 22 Apr 2023 22:27:22 GMT
    private static final TimeProvider ODD_SECOND = () -> LocalDateTime.
            ofEpochSecond(1682202443, 0, ZoneOffset.UTC); // Sat, 22 Apr 2023 22:27:23 GMT

    @Test
    void processEvenSecondProcessor() {
        var exceptionEvenSecondProcessor = new ExceptionEvenSecondProcessor(EVEN_SECOND);
        assertThrows(EvenSecondException.class,
                () -> exceptionEvenSecondProcessor.process(ORIGINAL_MESSAGE));
    }

    @Test
    void processOddSecondProcessor() {
        var exceptionEvenSecondProcessor = new ExceptionEvenSecondProcessor(ODD_SECOND);
        var processedMessage = exceptionEvenSecondProcessor.process(ORIGINAL_MESSAGE);
        assertNotNull(processedMessage);
    }
}
