package com.example.tlstore.services;

import com.example.tlstore.dtos.OrderItemDto;
import com.example.tlstore.entities.OrderItem;

import java.util.List;

public interface IOrderItemService {
    List<OrderItemDto> getALlOrderItemByOrderId(Long orderId);


    OrderItemDto addOrderItem(OrderItem orderItem);
}
