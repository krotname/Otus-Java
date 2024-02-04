package ru.otus.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@RedisHash("BasketR")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BasketR implements Serializable {
    @Id
    private UUID id;
    private String user;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}
