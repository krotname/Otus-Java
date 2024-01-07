package com.example.hw30https2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "random-ent", url = "https://localhost:8081/", configuration = TlsFeignConfiguration.class)
public interface RandomEnt {

    @GetMapping("/")
    Ent get();
}
