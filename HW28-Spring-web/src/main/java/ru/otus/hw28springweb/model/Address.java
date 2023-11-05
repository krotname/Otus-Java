package ru.otus.hw28springweb.model;

import jakarta.annotation.Nonnull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@ToString
@RequiredArgsConstructor
@Table("ADDRESSES")
public class Address {
    @Id
    private final Long clientId;
    private final Long clientsKey;
    private final Long clients;
    @Nonnull
    private final String street;
}


