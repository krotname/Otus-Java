package ru.otus.hw28springweb.model;

import lombok.*;


@Data
@NoArgsConstructor
public class Phone {
    Long id;
    private String number;
    @ToString.Exclude
    Client client;
}