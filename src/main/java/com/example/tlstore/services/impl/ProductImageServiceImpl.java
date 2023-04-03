package com.example.tlstore.services.impl;

import com.example.tlstore.dtos.ProductImageDto;
import com.example.tlstore.entities.ProductImage;
import com.example.tlstore.repositories.ProductImageRepository;
import com.example.tlstore.services.IProductImageService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductImageServiceImpl implements IProductImageService {
    private final ProductImageRepository productImageRepository;
    private ModelMapper modelMapper;

    @Override
    public List<ProductImageDto> getAllImageByProductId(Long productId){
        List<ProductImage> images = productImageRepository.findAllByProductId(productId);
        return images.stream()
                .map((image) -> modelMapper.map(image, ProductImageDto.class))
                .collect(Collectors.toList());
    }


}
