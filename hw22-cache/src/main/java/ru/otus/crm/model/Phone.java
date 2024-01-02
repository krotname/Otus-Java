package ru.otus.crm.model;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "phones")
@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    Client client;
    @Column(name = "number")
    private String number;

    public Phone(Long id, String number) {
        this.id = id;
        this.number = number;
    }
}