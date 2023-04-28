package ru.otus.dataprocessor;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileSerializer implements Serializer {
    private final static Gson GSON = new Gson();
    String fileName;

    public FileSerializer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void serialize(Map<String, Double> data) {
        try (var bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            String json = GSON.toJson(data);
            bufferedWriter.write(json);
        } catch (IOException e) {
            throw new FileProcessException(e);
        }
    }
}
