package ru.otus.hw28springweb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("phones")
public class Phone {

    @Id
    private final Long id;
    @Column("client_id")
    private final Long clientId;
    private final String number;
}