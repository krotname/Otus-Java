package ru.otus.shop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "characteristics", schema = "public")
public class Characteristic {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 255)
    @Column(name = "weight")
    private String weight;

    @Size(max = 255)
    @Column(name = "height")
    private String height;

    @Size(max = 255)
    @Column(name = "width")
    private String width;

    @Size(max = 255)
    @Column(name = "length")
    private String length;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "other")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> other;

}