package ru.otus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "shop_info", schema = "public")
public class ShopInfo {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Size(max = 255)
    @Column(name = "site_url")
    private String siteUrl;

    @Column(name = "year_of_foundation")
    private Long yearOfFoundation;

    @Size(max = 15)
    @Column(name = "phone", length = 15)
    private String phone;

    @Size(max = 15)
    @NotNull
    @Column(name = "inn", nullable = false, length = 15)
    private String inn;

    @Size(max = 15)
    @NotNull
    @Column(name = "kpp", nullable = false, length = 15)
    private String kpp;

}