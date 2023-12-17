package com.example.hw30https;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class Controller {

    @GetMapping("/")
    public Ent get(){
        return new Ent((ThreadLocalRandom.current().nextInt()));
    }
}
