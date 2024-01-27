package ru.otus.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.entity.ShopInfo;
import ru.otus.mapper.ShopInfoMapper;
import ru.otus.model.ShopInfoDto;
import ru.otus.repository.ShopInfoRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopInfoService {

    private final ShopInfoMapper shopInfoMapper;
    private final ShopInfoRepository shopInfoRepository;

    public ShopInfoDto getInfo() {
        ShopInfo info = shopInfoRepository.findAll().stream().findFirst().orElseThrow();
        log.info("getInfo {}", info.getName());
        ShopInfoDto shopInfoDto = shopInfoMapper.shopInfoToShopInfoDto(info);
        log.info("getInfo {}", shopInfoDto);
        return shopInfoDto;
    }
}
