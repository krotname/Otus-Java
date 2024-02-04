package ru.otus.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.otus.entity.Order;
import ru.otus.entity.ShopInfo;
import ru.otus.model.OrderDto;
import ru.otus.model.ShopInfoDto;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto orderToOrderDto(Order order);
}
