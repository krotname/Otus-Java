package ru.otus.shop.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.otus.shop.entities.ShopInfo;
import ru.otus.shop.mappers.ShopInfoMapper;
import ru.otus.shop.models.ShopInfoDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopInfoMapperTest {

    private final ShopInfoMapper shopInfoMapper = Mappers.getMapper(ShopInfoMapper.class);

    @Test
    public void testShopInfoToShopInfoDtoMapping() {
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setName("ShopName");
        ShopInfoDto shopInfoDto = shopInfoMapper.shopInfoToShopInfoDto(shopInfo);
        assertEquals(shopInfo.getName(), shopInfoDto.getName());
    }
}