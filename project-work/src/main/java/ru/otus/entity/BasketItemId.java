package ru.otus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Embeddable
public class BasketItemId implements Serializable {
    private static final long serialVersionUID = -8319147573897583867L;
    @NotNull
    @Column(name = "basket_id", nullable = false)
    private UUID basketId;

    @NotNull
    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BasketItemId entity = (BasketItemId) o;
        return Objects.equals(this.basketId, entity.basketId) &&
                Objects.equals(this.productId, entity.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basketId, productId);
    }

}