package ru.otus.dataprocessor;

import com.google.gson.Gson;
import ru.otus.model.Measurement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ResourcesFileLoader implements Loader {
    private final static Gson GSON = new Gson();
    String fileName;

    public ResourcesFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Measurement> load() {
        try (var bufferedReader = new BufferedReader(new FileReader(fileName))) {
            Measurement[] measurements = GSON.fromJson(bufferedReader, Measurement[].class);
            return Arrays.asList(measurements);
        } catch (IOException e) {
            throw new FileProcessException(e);
        }
    }
}
