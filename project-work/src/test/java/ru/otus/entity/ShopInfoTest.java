package ru.otus.entity;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopInfoTest {

    @Test
    public void testEqualsAndHashCode() {
        ShopInfo shopInfo1 = new ShopInfo("Shop1");
        shopInfo1.setInn("123123123");
        shopInfo1.setKpp("456456456");
        shopInfo1.setId(UUID.randomUUID());

        ShopInfo shopInfo2 = new ShopInfo("Shop1");
        shopInfo1.setInn("123123123");
        shopInfo1.setKpp("456456456");
        shopInfo2.setId(shopInfo1.getId());

        assertThat(shopInfo1).isEqualTo(shopInfo2);
        assertThat(shopInfo1.hashCode()).isEqualTo(shopInfo2.hashCode());
    }

    @Test
    public void testToString() {
        ShopInfo shopInfo = new ShopInfo("Shop2");
        shopInfo.setId(UUID.randomUUID());
        shopInfo.setDescription("Description2");
        shopInfo.setSiteUrl("www.shop2.com");
        shopInfo.setYearOfFoundation(2022L);
        shopInfo.setPhone("444-555-666");
        shopInfo.setInn("1234567890");
        shopInfo.setKpp("KPP123456789");

        String expectedToString = "ShopInfo{id=" + shopInfo.getId() + ", inn='1234567890', kpp='KPP123456789'}";

        assertThat(shopInfo.toString()).isEqualTo(expectedToString);
    }
}