package ru.otus.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.model.ShopInfoDto;
import ru.otus.service.SaleService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService service;
    @GetMapping("/{uuid}/")
    @Operation(description = "Новый заказ")
    public boolean newOrder(@PathVariable("uuid") UUID uuid) {
        return service.newOrder(uuid);
    }

}
