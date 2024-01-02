package ru.otus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacheApiApplication {

    // http://localhost:8080/swagger-ui/index.html
    public static void main(String[] args) {
        SpringApplication.run(CacheApiApplication.class, args);
    }
}