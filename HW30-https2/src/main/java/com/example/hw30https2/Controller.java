package com.example.hw30https2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final RandomEnt randomEnt;

    @GetMapping("/")
    public Ent get() {
        return randomEnt.get();
    }

    @GetMapping("/trustStore")
    public String trustStore() {
        return System.getProperty("javax.net.ssl.trustStore");
    }

}
