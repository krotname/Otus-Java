package ru.otus.shop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.otus.shop.entities.ShopInfo;
import ru.otus.shop.models.ShopInfoDto;

@Mapper(componentModel = "spring")
public interface ShopInfoMapper {
    @Mapping(target = "name", source = "name")
    ShopInfoDto shopInfoToShopInfoDto(ShopInfo shopInfo);
}
