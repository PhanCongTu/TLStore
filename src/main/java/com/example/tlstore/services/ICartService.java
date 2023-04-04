package com.example.tlstore.services;

import com.example.tlstore.dtos.CartDto;

import java.util.List;

public interface ICartService {
    List<CartDto> getAllCartByUserId(Long userId);


    CartDto addCart(CartDto cartDto, Long userId);
}
