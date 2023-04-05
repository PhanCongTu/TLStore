package com.example.tlstore.services.impl;

import com.example.tlstore.dtos.OrderItemDto;
import com.example.tlstore.entities.OrderItem;
import com.example.tlstore.repositories.OrderItemRepository;
import com.example.tlstore.services.IOrderItemService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements IOrderItemService {
    private OrderItemRepository orderItemRepository;
    private ModelMapper modelMapper;

    @Override
    public List<OrderItemDto> getALlOrderItemByOrderId(Long orderId){
        List<OrderItem> orderItems = orderItemRepository.findAllByOrderId(orderId);
        return orderItems.stream()
                .map((oderItem) -> modelMapper.map(oderItem, OrderItemDto.class))
                .collect(Collectors.toList());
    }
}
