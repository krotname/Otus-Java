package ru.otus.hw28springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
public class Hw28SpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hw28SpringWebApplication.class, args);
    }

}
