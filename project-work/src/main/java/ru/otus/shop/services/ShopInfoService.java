package ru.otus.shop.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.shop.entities.ShopInfo;
import ru.otus.shop.mappers.ShopInfoMapper;
import ru.otus.shop.models.ShopInfoDto;
import ru.otus.shop.repositories.ShopInfoRepository;
import ru.otus.shop.models.ShopInfoDto;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopInfoService {

    private final ShopInfoMapper shopInfoMapper;
    private final ShopInfoRepository shopInfoRepository;

    @Transactional
    public ShopInfoDto getInfo() {
        ShopInfo info = shopInfoRepository.findAll().stream().findFirst().orElseThrow();
        log.info("getInfo {}", info.getName());
        ShopInfoDto shopInfoDto = shopInfoMapper.shopInfoToShopInfoDto(info);
        log.info("getInfo {}", shopInfoDto);
        return shopInfoDto;
    }
}
