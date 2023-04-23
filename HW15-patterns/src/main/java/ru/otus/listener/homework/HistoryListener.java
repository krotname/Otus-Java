package ru.otus.listener.homework;

import org.apache.commons.lang3.SerializationUtils;
import ru.otus.listener.Listener;
import ru.otus.model.Message;

import java.util.HashMap;
import java.util.Optional;

public class HistoryListener implements Listener, HistoryReader {

    private final HashMap<Long, Message> map = new HashMap<>();

    @Override
    public void onUpdated(Message msg) {
        var deepCopy = SerializationUtils.clone(msg);
        map.put(msg.getId(), deepCopy);
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        return Optional.ofNullable(map.get(id));
    }
}
