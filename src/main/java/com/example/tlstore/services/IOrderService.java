package com.example.tlstore.services;

import com.example.tlstore.dtos.OrderDto;
import com.example.tlstore.entities.Order;

import java.util.List;

public interface IOrderService {
    List<OrderDto> getAllOrder(Long userId);

    OrderDto newOrder(OrderDto orderDto);

//    void deleteOrder(Long orderId);

    void deleteOrder(Order order);
}
