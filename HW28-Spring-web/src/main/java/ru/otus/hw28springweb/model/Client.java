package ru.otus.hw28springweb.model;

import jakarta.annotation.Nonnull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Set;

@Data
@Table("CLIENTS")
public class Client {

    @Id
    private  Long id;

    private  String name;

//    @MappedCollection(idColumn = "client_id", keyColumn =  "client_id")
    private  List<Address> address;

    //@MappedCollection(idColumn = "client_id")
    private Set<Phone> phones;

//    @PersistenceCreator
//    public Client(@Nonnull String name, List<Address> address, List<Phone> phones) {
//        this(null, name, address, phones);
//    }
}