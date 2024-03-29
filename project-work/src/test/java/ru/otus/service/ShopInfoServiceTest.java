package ru.otus.shop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.shop.entities.ShopInfo;
import ru.otus.shop.mappers.ShopInfoMapper;
import ru.otus.shop.models.ShopInfoDto;
import ru.otus.shop.repositories.ShopInfoRepository;
import ru.otus.shop.services.ShopInfoService;

import java.util.Collections;

import static org.mockito.Mockito.when;

@SpringBootTest
@Disabled
public class ShopInfoServiceTest {

    @Mock
    private ShopInfoRepository shopInfoRepository;

    @Mock
    private ShopInfoMapper shopInfoMapper;

    @InjectMocks
    private ShopInfoService shopInfoService;

    @Test
    public void testGetInfo() {
        ShopInfo mockShopInfo = new ShopInfo();
        mockShopInfo.setName("MockShop");
        ShopInfoDto mockShopInfoDto = new ShopInfoDto("MockShop", "Description", "www.mockshop.com",
                2022L, "123-456-789", "1234567890", "KPP123456789");
        when(shopInfoRepository.findAll()).thenReturn(Collections.singletonList(mockShopInfo));
        when(shopInfoMapper.shopInfoToShopInfoDto(mockShopInfo)).thenReturn(mockShopInfoDto);
        ShopInfoDto result = shopInfoService.getInfo();
        Assertions.assertEquals("MockShop", result.getName());
    }
}