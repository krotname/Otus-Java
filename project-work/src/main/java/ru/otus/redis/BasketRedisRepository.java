package ru.otus.redis;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.entity.BasketR;

public interface BasketRedisRepository extends CrudRepository<BasketR, String> {

}
