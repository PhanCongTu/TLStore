package com.example.tlstore.services;

import com.example.tlstore.dtos.ProductImageDto;

import java.util.List;

public interface IProductImageService {
    List<ProductImageDto> getAllImageByProductId(Long productId);
}
