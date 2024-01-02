package ru.otus.hw28springweb.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("addresses")
public class Address {

    @Id
    private final Long id;
    @Column("client_id")
    private final Long clientId;
    private final String street;

}


