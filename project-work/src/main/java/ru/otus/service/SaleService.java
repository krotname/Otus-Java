package ru.otus.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.entity.BasketR;
import ru.otus.mapper.OrderMapper;
import ru.otus.model.OrderDto;
import ru.otus.redis.BasketRedisRepository;
import ru.otus.repository.OrderItemRepository;
import ru.otus.repository.ProductRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaleService {

    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final BasketRedisRepository basketRedisRepository;
    private final OrderMapper orderMapper;

    public boolean newOrder(OrderDto order) {

        BasketR basketR = new BasketR();
        basketR.setId(UUID.randomUUID());
        return true;
    }

    public OrderDto getOrder(@PathVariable("uuid") UUID uuid) {
        log.info("getOrder {}", uuid );
        BasketR order = basketRedisRepository.findById(uuid.toString()).orElseThrow();
        log.info("getOrder {} ", order);
//        orderMapper.orderToOrderDto(); // todo другое дто
        return null;
    }
}
