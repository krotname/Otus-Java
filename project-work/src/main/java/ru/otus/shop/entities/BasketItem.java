package ru.otus.shop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "basket_items", schema = "public")
public class BasketItem {
    @EmbeddedId
    private BasketItemId id;

    @MapsId("basketId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "basket_id", nullable = false)
    private Basket basket;

    @MapsId("productId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

}