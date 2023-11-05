package ru.otus.hw28springweb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("addresses")
public class Address {

    @Id
    private Long id;
    @Column("client_id")
    private Long clientId;
    private String street;

}


