package com.example.tlstore.controllers;

import com.example.tlstore.dtos.OrderDto;
import com.example.tlstore.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    IOrderService iOrderService;

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderDto>> getAllCart(Long userId){
        List<OrderDto> orderDtos = iOrderService.getAllOrder(userId);
         return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }
}
