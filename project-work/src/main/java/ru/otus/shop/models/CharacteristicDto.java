package ru.otus.shop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacteristicDto {
    private UUID id;
    private String weight;

    private String height;
    private String width;
    private String length;
    private String description;
    private Map<String, Object> other;
}
