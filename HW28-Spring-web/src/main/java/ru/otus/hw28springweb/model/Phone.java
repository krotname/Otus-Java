package ru.otus.hw28springweb.model;

import jakarta.annotation.Nonnull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("phones")
public class Phone {

    @Id
    private Long id;
    @Column("client_id")
    private Long clientId;  // Добавлено поле client_id
    private String number;

    // Геттеры, сеттеры и конструкторы
}