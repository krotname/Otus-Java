package ru.otus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopInfoDto {
    private String name;
    private String description;
    private String siteUrl;
    private Long yearOfFoundation;
    private String phone;
    private String inn;
    private String kpp;
}
