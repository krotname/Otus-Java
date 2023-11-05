package ru.otus.hw28springweb.model;

import jakarta.annotation.Nonnull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Getter
@ToString
@Table("CLIENTS")
public class Client {

    @Id
    private final Long id;

    @Nonnull
    private final String name;

//    @MappedCollection(idColumn = "client_id", keyColumn =  "client_id")
    private final List<Address> address;

//    @MappedCollection(idColumn = "client_id", keyColumn =  "client_id")
    private final List<Phone> phones;

    public Client(Long id, @Nonnull String name, List<Address> address, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phones = phones;
    }

//    @PersistenceCreator
//    public Client(@Nonnull String name, List<Address> address, List<Phone> phones) {
//        this(null, name, address, phones);
//    }
}