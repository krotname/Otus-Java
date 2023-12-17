package com.example.hw30https2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Hw30Https2Application {

    public static void main(String[] args) {
        SpringApplication.run(Hw30Https2Application.class, args);
    }

}
