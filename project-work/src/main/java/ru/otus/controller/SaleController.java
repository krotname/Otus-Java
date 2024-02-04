package ru.otus.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.model.OrderDto;
import ru.otus.service.SaleService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService service;

    @PostMapping("/")
    @Operation(description = "Новый заказ")
    public boolean newOrder(@RequestParam OrderDto order) {
        return service.newOrder(order);
    }

    @GetMapping("/{uuid}/")
    @Operation(description = "Информация о заказе")
    public OrderDto getOrder(@PathVariable("uuid") UUID uuid) {
        return service.getOrder(uuid);
    }

}
