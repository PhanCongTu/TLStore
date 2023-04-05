package com.example.tlstore.services.impl;

import com.example.tlstore.dtos.OrderDto;
import com.example.tlstore.entities.Order;
import com.example.tlstore.repositories.OrderRepository;
import com.example.tlstore.services.ICartService;
import com.example.tlstore.services.IOrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final OrderRepository orderRepository;
    private final ICartService iCartService;
    private ModelMapper modelMapper;

    @Override
    public List<OrderDto> getAllOrder(Long userId){
        List<Order> orders = orderRepository.findAllByUserId(userId);
        return orders.stream()
                .map((order) -> (modelMapper.map(order, OrderDto.class)))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto newOrder(OrderDto orderDto){
        Order order = modelMapper.map(orderDto, Order.class);
        Order savedOrder = orderRepository.save(order);
        OrderDto saveCategoryDto = modelMapper.map(savedOrder, OrderDto.class);
        return saveCategoryDto;

    }
}
