package ru.otus.hw36grpcclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Hw36GRpcClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hw36GRpcClientApplication.class, args);
    }

}
