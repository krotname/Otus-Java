package ru.otus.hw28springweb.model;

import jakarta.annotation.Nonnull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@ToString
@RequiredArgsConstructor
@Table("PHONES")
public class Phone {
    @Id
    private final Long clientId;
    private final Long clientsKey;
    @Nonnull
    private final String number;


    @ToString.Exclude
    private final Client client;
}