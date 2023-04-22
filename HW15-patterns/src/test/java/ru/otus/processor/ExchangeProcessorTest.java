package ru.otus.processor;

import org.junit.jupiter.api.Test;
import ru.otus.handler.ComplexProcessor;
import ru.otus.model.Message;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class ExchangeProcessorTest {

    @Test
    void processTest() {
        var originalMessage = new Message.Builder(1L).field10("--10--").field11("++11++").field12("**12**").build();

        var exchangeProcessor =  new ExchangeProcessor();

        var processedMessage = exchangeProcessor.process(originalMessage);

        System.out.println(originalMessage);
        System.out.println(processedMessage);

        assertThat(originalMessage.getField9()).isEqualTo(processedMessage.getField9());
        assertThat(originalMessage.getField10()).isEqualTo(processedMessage.getField10());

        assertThat(originalMessage.getField11()).isEqualTo(processedMessage.getField12());
        assertThat(originalMessage.getField12()).isEqualTo(processedMessage.getField11());
    }
}