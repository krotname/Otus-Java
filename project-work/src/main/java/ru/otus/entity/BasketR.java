package ru.otus.entity;

import lombok.*;
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
