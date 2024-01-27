package ru.otus.service;

import org.springframework.stereotype.Service;
import ru.otus.model.ShopInfoDto;

@Service
public class ShopInfoService {

    public ShopInfoDto getInfo() {
        return ShopInfoDto.builder().name("Test").build(); // todo impl
    }
}
