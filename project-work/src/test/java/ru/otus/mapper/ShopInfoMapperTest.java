package ru.otus.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.otus.entity.ShopInfo;
import ru.otus.model.ShopInfoDto;

import static org.junit.jupiter.api.Assertions.*;

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