package ru.otus.shop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.shop.models.ShopInfoDto;
import ru.otus.shop.services.ShopInfoService;

@RestController
@RequestMapping("/api/shop-info")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Информация о магазине", description = "Предоставляет информацию о магазине")
public class ShopInfoController {

    private final ShopInfoService shopInfoService;

    @Operation(summary = "Получить информацию о магазине", description = "Возвращает информацию о магазине, включая контакты, адрес и часы работы")
    @GetMapping
    public ResponseEntity<ShopInfoDto> getShopInfo() {
        log.info("Запрос на получение информации о магазине");
        ShopInfoDto shopInfo = shopInfoService.getInfo();
        if (shopInfo != null) {
            return new ResponseEntity<>(shopInfo, HttpStatus.OK);
        } else {
            log.warn("Информация о магазине не найдена");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
