package com.example.tlstore.services.impl;

import com.example.tlstore.dtos.ProductImageDto;
import com.example.tlstore.entities.Category;
import com.example.tlstore.entities.Product;
import com.example.tlstore.entities.ProductImage;
import com.example.tlstore.exceptions.NotFoundException;
import com.example.tlstore.repositories.ProductImageRepository;
import com.example.tlstore.services.IProductImageService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductImageServiceImpl implements IProductImageService {
    private final ProductImageRepository productImageRepository;
    private final ProductServiceImpl productService;
    private ModelMapper modelMapper;

    @Override
    public List<ProductImageDto> getAllImageByProductId(Long productId){
        List<ProductImage> images = productImageRepository.findAllByProductId(productId);
        return images.stream()
                .map((image) -> modelMapper.map(image, ProductImageDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductImageDto addProductImage(ProductImageDto productImageDto, Long productId) {
        ProductImage newImage = modelMapper.map(productImageDto, ProductImage.class);
        newImage.setProduct(modelMapper.map(productService.getProductById(productId), Product.class));
        ProductImage savedImage = productImageRepository.save(newImage);
        ProductImageDto saveImageDto = modelMapper.map(savedImage, ProductImageDto.class);
        return saveImageDto;
    }
    @Override
    public void deleteProductImage(Long pImage) {
        Optional<ProductImage> existingPImage = productImageRepository.findById(pImage);
        if (!existingPImage.isPresent()) throw new NotFoundException("Product Image do not exist!");
        productImageRepository.delete(existingPImage.get());
    }

}
