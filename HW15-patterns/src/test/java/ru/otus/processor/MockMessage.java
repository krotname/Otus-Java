package ru.otus.processor;

import ru.otus.model.Message;

public class MockMessage {
    public static final Message ORIGINAL_MESSAGE = new Message.Builder(1L)
            .field10("--10--")
            .field11("++11++")
            .field12("**12**")
            .build();
}
