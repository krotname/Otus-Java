package ru.otus.dataprocessor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import ru.otus.model.Measurement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class ResourcesFileLoader implements Loader {
    private final ObjectMapper mapper = new ObjectMapper();
    private final Gson gson = new Gson();
    String fileName;

    public ResourcesFileLoader(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public List<Measurement> load() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            Measurement[] measurements = gson.fromJson(bufferedReader, Measurement[].class);
            return Arrays.asList(measurements);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
