package ru.otus.shop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.shop.models.OrderDto;
import ru.otus.shop.services.SaleService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Продажи", description = "Управление продажами")
public class SaleController {

    private final SaleService saleService;

    @Operation(summary = "Создать заказ", description = "Создает новый заказ на основе переданных данных")
    @ApiResponse(responseCode = "201", description = "Заказ успешно создан",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = OrderDto.class)))
    @PostMapping
    public ResponseEntity<OrderDto> createSale(@RequestBody @Parameter(description = "Данные заказа") OrderDto orderDto) {
        log.info("Запрос на создание нового заказа");
        OrderDto createdSale = saleService.createSale(orderDto);
        return new ResponseEntity<>(createdSale, HttpStatus.CREATED);
    }

    @Operation(summary = "Получить историю заказов пользователя", description = "Возвращает список заказов, сделанных пользователем")
    @ApiResponse(responseCode = "200", description = "История заказов получена",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = OrderDto.class)))
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> getUserSales(@PathVariable @Parameter(description = "ID пользователя, историю заказов которого нужно получить") UUID userId) {
        log.info("Запрос на получение истории заказов пользователя с ID: {}", userId);
        List<OrderDto> userSales = saleService.getUserSales(userId);
        return new ResponseEntity<>(userSales, HttpStatus.OK);
    }
}