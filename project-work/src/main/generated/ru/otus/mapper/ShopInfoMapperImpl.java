package ru.otus.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.otus.entity.ShopInfo;
import ru.otus.model.ShopInfoDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-04T13:49:30+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class ShopInfoMapperImpl implements ShopInfoMapper {

    @Override
    public ShopInfoDto shopInfoToShopInfoDto(ShopInfo shopInfo) {
        if ( shopInfo == null ) {
            return null;
        }

        ShopInfoDto.ShopInfoDtoBuilder shopInfoDto = ShopInfoDto.builder();

        shopInfoDto.name( shopInfo.getName() );
        shopInfoDto.description( shopInfo.getDescription() );
        shopInfoDto.siteUrl( shopInfo.getSiteUrl() );
        shopInfoDto.yearOfFoundation( shopInfo.getYearOfFoundation() );
        shopInfoDto.phone( shopInfo.getPhone() );
        shopInfoDto.inn( shopInfo.getInn() );
        shopInfoDto.kpp( shopInfo.getKpp() );

        return shopInfoDto.build();
    }
}
