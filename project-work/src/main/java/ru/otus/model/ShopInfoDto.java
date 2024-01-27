package ru.otus.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopInfoDto {
    private String name;
    private String description;
    private String siteUrl;
    private Long yearOfFoundation;
    private String phone;
    private String inn;
    private String kpp;
}
