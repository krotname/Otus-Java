package ru.otus.hw28springweb.model;

import jakarta.annotation.Nonnull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("PHONES")
public class Phone {
    @Id
    private final int id;
    private final int clientId;
    @Nonnull
    private final String number;


    @ToString.Exclude
    private final Client client;
}