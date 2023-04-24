package ru.otus.processor;

import org.junit.jupiter.api.Test;
import ru.otus.processor.homework.ExchangeProcessor;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.otus.processor.MockMessage.ORIGINAL_MESSAGE;

class ExchangeProcessorTest {

    @Test
    void processTest() {
        var exchangeProcessor = new ExchangeProcessor();

        var processedMessage = exchangeProcessor.process(ORIGINAL_MESSAGE);

        assertThat(ORIGINAL_MESSAGE.getField9()).isEqualTo(processedMessage.getField9());
        assertThat(ORIGINAL_MESSAGE.getField10()).isEqualTo(processedMessage.getField10());

        assertThat(ORIGINAL_MESSAGE.getField11()).isEqualTo(processedMessage.getField12());
        assertThat(ORIGINAL_MESSAGE.getField12()).isEqualTo(processedMessage.getField11());
    }
}
