package ru.otus.shop.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.shop.entities.Order;
import ru.otus.shop.mappers.OrderMapper;
import ru.otus.shop.models.OrderDto;
import ru.otus.shop.repositories.OrderRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaleService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Transactional
    public OrderDto createSale(OrderDto orderDto) {
        log.info("Создание нового заказа с данными: {}", orderDto);
        Order order = orderMapper.orderDtoToOrder(orderDto);
        order.setId(UUID.randomUUID());
        order = orderRepository.save(order);
        return orderMapper.orderToOrderDto(order);
    }

    @Transactional
    public List<OrderDto> getUserSales(UUID userId) {
        log.info("Получение истории заказов пользователя с ID: {}", userId);
        List<Order> orders = orderRepository.findAllByUserId(userId);
        return orders.stream().map(orderMapper::orderToOrderDto).toList();
    }


}
