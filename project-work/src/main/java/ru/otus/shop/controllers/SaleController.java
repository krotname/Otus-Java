package ru.otus.shop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.shop.models.OrderDto;
import ru.otus.shop.services.SaleService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService service;

    @PostMapping("/")
    @Operation(description = "Новый заказ")
    public OrderDto newOrder(@RequestParam OrderDto order) {
        return service.newOrder(order);
    }

    @GetMapping("/{uuid}/")
    @Operation(description = "Информация о заказе")
    public OrderDto getOrder(@PathVariable("uuid") UUID uuid) {
        return service.getOrder(uuid);
    }

}
