package ru.otus.shop.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.shop.entities.BasketR;
import ru.otus.shop.mappers.OrderMapper;
import ru.otus.shop.models.OrderDto;
import ru.otus.shop.repositories.redis.BasketRedisRepository;
import ru.otus.shop.repositories.OrderItemRepository;
import ru.otus.shop.repositories.ProductRepository;
import ru.otus.shop.models.OrderDto;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaleService {

    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final BasketRedisRepository basketRedisRepository;
    private final OrderMapper orderMapper;

    public OrderDto newOrder(OrderDto order) {

        BasketR basketR = new BasketR();
        basketR.setId(UUID.randomUUID());
        return order;
    }

    public OrderDto getOrder(@PathVariable("uuid") UUID uuid) {
        log.info("getOrder {}", uuid );
        BasketR order = basketRedisRepository.findById(uuid.toString()).orElseThrow();
        log.info("getOrder {} ", order);
//        orderMapper.orderToOrderDto(); // todo другое дто
        return null;
    }

    public OrderDto createSale(OrderDto orderDto) { // todo
        return null;
    }

    public List<OrderDto> getUserSales(UUID userId) { // todo
        return null;
    }
}
