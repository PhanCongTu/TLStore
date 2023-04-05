package com.example.tlstore.dtos;

import com.example.tlstore.entities.OrderItem;
import com.example.tlstore.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private long id;

    private String address;

    private String phoneNumber;

    private int status;

    private double total;

    private UserDto user;

    private List<OrderItemDto> orderItems;
}
