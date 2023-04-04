package com.example.tlstore.services;

import com.example.tlstore.dtos.ProductImageDto;

import java.util.List;

public interface IProductImageService {
    List<ProductImageDto> getAllImageByProductId(Long productId);

    ProductImageDto addProductImage(ProductImageDto productImageDto, Long productId);

    void deleteProductImage(Long pImage);
}
