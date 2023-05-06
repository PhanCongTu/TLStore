package com.example.tlstore.services;

import com.example.tlstore.Model.Mail;
import com.example.tlstore.dtos.OrderDto;
import com.example.tlstore.dtos.OrderItemDto;
import com.example.tlstore.dtos.UserDto;

import java.util.List;

public interface IMailService {
    public void sendEmail(Mail mail);
    public void sendOrderMail(UserDto userDto, OrderDto orderDto, List<OrderItemDto> orderItemDtos);
}
