package com.example.tlstore.services;

import com.example.tlstore.dtos.OrderItemDto;

import java.util.List;

public interface IOrderItemService {
    List<OrderItemDto> getALlOrderItemByOrderId(Long orderId);
}
