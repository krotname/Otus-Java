package ru.otus.hw28springweb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Client implements Cloneable {

    @Id
    private Long id;
    private String name;
    private Address address;
    private List<Phone> phones;

    public Client(String name) {
        this.id = null;
        this.name = name;
    }

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client(Long id, String name, Address address, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phones = phones;
        this.insertPhones(phones);
    }

    @Override
    public Client clone() {
        return new Client(this.id, this.name, this.address, this.phones);
    }

    private void insertPhones(List<Phone> phones) {
        if (phones != null) {
            for (Phone phone : phones) {
                phone.setClient(this);
            }
        }
    }
}