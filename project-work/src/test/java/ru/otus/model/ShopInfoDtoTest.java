package ru.otus.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ShopInfoDtoTest {

    @Test
    public void testConstructorWithAllParameters() {
        ShopInfoDto shopInfo = new ShopInfoDto("ShopName", "Description", "www.example.com",
                2020L, "123-456-789", "1234567890", "KPP123456789");

        assertEquals("ShopName", shopInfo.getName());
        assertEquals("Description", shopInfo.getDescription());
        assertEquals("www.example.com", shopInfo.getSiteUrl());
        assertEquals(2020L, shopInfo.getYearOfFoundation());
        assertEquals("123-456-789", shopInfo.getPhone());
        assertEquals("1234567890", shopInfo.getInn());
        assertEquals("KPP123456789", shopInfo.getKpp());
    }

    @Test
    public void testEqualsAndHashCode() {
        ShopInfoDto shopInfo1 = new ShopInfoDto("ShopName", "Description", "www.example.com",
                2020L, "123-456-789", "1234567890", "KPP123456789");

        ShopInfoDto shopInfo2 = new ShopInfoDto("ShopName", "Description", "www.example.com",
                2020L, "123-456-789", "1234567890", "KPP123456789");

        assertEquals(shopInfo1, shopInfo2);
        assertEquals(shopInfo1.hashCode(), shopInfo2.hashCode());
    }

    @Test
    public void testToString() {
        ShopInfoDto shopInfo = new ShopInfoDto("ShopName", "Description", "www.example.com",
                2020L, "123-456-789", "1234567890", "KPP123456789");

        String expectedToString = "ShopInfoDto(name=ShopName, description=Description, siteUrl=www.example.com, " +
                "yearOfFoundation=2020, phone=123-456-789, inn=1234567890, kpp=KPP123456789)";

        assertEquals(expectedToString, shopInfo.toString());
    }

    @Test
    public void testBuilder() {
        ShopInfoDto shopInfoDto = ShopInfoDto.builder()
                .name("TestShop")
                .description("Test Description")
                .siteUrl("www.testshop.com")
                .yearOfFoundation(2020L)
                .phone("123-456-789")
                .inn("1234567890")
                .kpp("KPP123456789")
                .build();

        assertThat(shopInfoDto.getName()).isEqualTo("TestShop");
        assertThat(shopInfoDto.getDescription()).isEqualTo("Test Description");
        assertThat(shopInfoDto.getSiteUrl()).isEqualTo("www.testshop.com");
        assertThat(shopInfoDto.getYearOfFoundation()).isEqualTo(2020L);
        assertThat(shopInfoDto.getPhone()).isEqualTo("123-456-789");
        assertThat(shopInfoDto.getInn()).isEqualTo("1234567890");
        assertThat(shopInfoDto.getKpp()).isEqualTo("KPP123456789");
    }

}