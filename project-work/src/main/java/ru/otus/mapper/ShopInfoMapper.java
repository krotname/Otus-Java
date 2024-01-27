package ru.otus.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.otus.entity.ShopInfo;
import ru.otus.model.ShopInfoDto;

@Mapper(componentModel = "spring")
public interface ShopInfoMapper {
    @Mapping(target = "name", source = "name")
    ShopInfoDto shopInfoToShopInfoDto(ShopInfo shopInfo);
}
