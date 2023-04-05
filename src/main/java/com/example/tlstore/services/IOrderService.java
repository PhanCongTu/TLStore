package com.example.tlstore.services;

import com.example.tlstore.dtos.OrderDto;

import java.util.List;

public interface IOrderService {
    List<OrderDto> getAllOrder(Long userId);

    OrderDto newOrder(OrderDto orderDto);
}
