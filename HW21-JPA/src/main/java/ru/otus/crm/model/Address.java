package ru.otus.crm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "street")
    private String street;
    @OneToOne(mappedBy = "address",  cascade = CascadeType.ALL)
    private Client client;

    public Address(Long id, String street) {
        this.id = id;
        this.street = street;
    }
}
