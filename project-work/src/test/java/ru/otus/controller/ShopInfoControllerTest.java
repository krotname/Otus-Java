package ru.otus.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.model.ShopInfoDto;
import ru.otus.service.ShopInfoService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

@WebMvcTest(ShopInfoController.class)
public class ShopInfoControllerTest {

    @MockBean
    private ShopInfoService shopInfoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetInfo() throws Exception {
        ShopInfoDto mockShopInfoDto = new ShopInfoDto("MockShop", "Description", "www.mockshop.com",
                2022L, "123-456-789", "1234567890", "KPP123456789");

        when(shopInfoService.getInfo()).thenReturn(mockShopInfoDto);

        mockMvc.perform(get("/api/v1/shop-info/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("MockShop"))
                .andExpect(jsonPath("$.siteUrl").value("www.mockshop.com"));
    }
}