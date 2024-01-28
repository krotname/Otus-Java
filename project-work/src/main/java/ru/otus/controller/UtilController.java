package ru.otus.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ru.otus.util.AppUtil.randomUUID;

@RestController
@RequestMapping("/util/v1/generate-uuid")
@RequiredArgsConstructor
public class UtilController {
    @GetMapping("/")
    public String getInfo() {
        return randomUUID();
    }
}
