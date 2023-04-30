package ru.otus.dataprocessor;

import org.junit.jupiter.api.Test;

class ResourcesFileLoaderTest {

    @Test
    void load() {
        ResourcesFileLoader resourcesFileLoader = new ResourcesFileLoader("/inputData.json");
        resourcesFileLoader.load().forEach(System.out::println);
    }
}