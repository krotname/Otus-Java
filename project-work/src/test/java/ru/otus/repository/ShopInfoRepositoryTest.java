package ru.otus.shop.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.shop.entities.ShopInfo;
import ru.otus.shop.repositories.ShopInfoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ShopInfoRepositoryTest {

    @Autowired
    private ShopInfoRepository shopInfoRepository;

    @Test
    public void testSaveAndFindById() {
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setName("TestShop");
        shopInfo.setId(UUID.randomUUID());

        ShopInfo savedShopInfo = shopInfoRepository.save(shopInfo);

        Optional<ShopInfo> foundShopInfo = shopInfoRepository.findById(savedShopInfo.getId());

        assertTrue(foundShopInfo.isPresent());
        assertEquals("TestShop", foundShopInfo.get().getName());
    }

    @Test
    public void testFindAll() {
        ShopInfo shop1 = new ShopInfo("Shop1");
        ShopInfo shop2 = new ShopInfo("Shop2");
        shop1.setId(UUID.randomUUID());
        shop2.setId(UUID.randomUUID());
        shop1.setKpp("someKppValue");
        shop2.setKpp("someKppValue");
        shop1.setInn("someInnValue");
        shop2.setInn("someInnValue");

        shopInfoRepository.save(shop1);
        shopInfoRepository.save(shop2);

        List<ShopInfo> shopInfos = shopInfoRepository.findAll();

        assertFalse(shopInfos.isEmpty());
        assertEquals(3, shopInfos.size());
    }
}