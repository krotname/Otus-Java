package ru.otus.shop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.net.InetAddress;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 255)
    @NotNull
    @Column(name = "login", nullable = false)
    private String login;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 255)
    @NotNull
    @Column(name = "salt", nullable = false)
    private String salt;

    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;

    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 15)
    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "birthday")
    private LocalDate birthday;

    @NotNull
    @Column(name = "employee", nullable = false)
    private Short employee;

    @Size(max = 15)
    @Column(name = "inn", length = 15)
    private String inn;

    @Size(max = 15)
    @Column(name = "passport_number", length = 15)
    private String passportNumber;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;
    @Column(name = "ip_address")
    private InetAddress ipAddress;

/*
 TODO [JPA Buddy] create field to map the 'sex' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "sex", columnDefinition = "gender(0, 0)")
    private Object sex;
*/
}