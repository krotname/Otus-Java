package ru.otus.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.model.ShopInfoDto;
import ru.otus.service.ShopInfoService;

@RestController
@RequestMapping("/api/v1/shop-info")
@RequiredArgsConstructor
public class ShopInfoController {
    private final ShopInfoService shopInfoService;

    @GetMapping("/")
    public ShopInfoDto getInfo() {
        return shopInfoService.getInfo();
    }
}
