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
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "number")
    private String number;
    @ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    public Phone(Long id, String number) {
        this.id = id;
        this.number = number;
    }
}
