package ru.otus.dataprocessor;

import com.google.gson.Gson;
import ru.otus.model.Measurement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ResourcesFileLoader implements Loader {
    private final static Gson GSON = new Gson();
    String fileName;

    public ResourcesFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Measurement> load() {
        try (var bufferedReader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream(fileName))))) {
            var measurements = GSON.fromJson(bufferedReader, Measurement[].class);
            return Arrays.asList(measurements);
        } catch (IOException | NullPointerException e) {
            throw new FileProcessException(e);
        }
    }
}
