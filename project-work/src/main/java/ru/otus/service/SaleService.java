package ru.otus.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.entity.BasketR;
//import ru.otus.redis.BasketRedisRepository;
import ru.otus.redis.BasketRedisRepository;
import ru.otus.repository.OrderItemRepository;
import ru.otus.repository.ProductRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaleService {

    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final BasketRedisRepository basketRedisRepository;

    public boolean newOrder(UUID uuid){
        log.warn(uuid.toString());
        BasketR basketR = new BasketR();
        basketR.setId(uuid);
        basketRedisRepository.save(basketR);
        return true;
    }
}
