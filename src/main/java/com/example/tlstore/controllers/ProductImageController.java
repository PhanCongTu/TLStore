package com.example.tlstore.controllers;

import com.example.tlstore.dtos.CategoryDto;
import com.example.tlstore.dtos.ProductImageDto;
import com.example.tlstore.services.IProductImageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-image")
public class ProductImageController {
    @Autowired
    IProductImageService iProductImageService;

    @GetMapping("/{productId}")
    @ApiOperation(value = "Lấy tất cả ảnh Product theo Product Id")
    public ResponseEntity<List<ProductImageDto>> getAllCategories(@PathVariable("productId") Long productId) {
        List<ProductImageDto> listImages = iProductImageService.getAllImageByProductId(productId);
        if (listImages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listImages, HttpStatus.OK);
    }
}
