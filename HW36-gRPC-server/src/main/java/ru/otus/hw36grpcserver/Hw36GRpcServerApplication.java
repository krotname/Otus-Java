package ru.otus.hw36grpcserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Hw36GRpcServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hw36GRpcServerApplication.class, args);
    }

}
