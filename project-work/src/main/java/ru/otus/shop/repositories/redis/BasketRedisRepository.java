package ru.otus.shop.repositories.redis;

import org.springframework.data.repository.CrudRepository;
import ru.otus.shop.entities.BasketR;

import java.util.Optional;

public interface BasketRedisRepository extends CrudRepository<BasketR, String> {

    @Override
    Optional<BasketR> findById(String s);
}
