package ru.otus.redis;

import org.springframework.data.repository.CrudRepository;
import ru.otus.entity.BasketR;

public interface BasketRedisRepository extends CrudRepository<BasketR, String> {

}
