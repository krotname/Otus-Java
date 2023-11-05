package ru.otus.hw28springweb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Data
@Table("clients")
public class Client {

    @Id
    private Long id;
    private String name;

    @MappedCollection(idColumn = "client_id")
    private Set<Address> addresses;

    @MappedCollection(idColumn = "client_id")
    private Set<Phone> phones;

}