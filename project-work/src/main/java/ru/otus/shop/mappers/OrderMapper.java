package ru.otus.shop.mappers;

import org.mapstruct.Mapper;
import ru.otus.shop.entities.Order;
import ru.otus.shop.models.OrderDto;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto orderToOrderDto(Order order);
}
