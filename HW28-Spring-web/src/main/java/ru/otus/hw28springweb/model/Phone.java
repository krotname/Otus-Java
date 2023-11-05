package ru.otus.hw28springweb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("phones")
public class Phone {

    @Id
    private Long id;
    @Column("client_id")
    private Long clientId;
    private String number;
}