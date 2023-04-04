package com.example.tlstore.controllers;

import com.example.tlstore.dtos.*;
import com.example.tlstore.dtos.ProductDto;
import com.example.tlstore.entities.Category;
import com.example.tlstore.entities.ProductImage;
import com.example.tlstore.services.ICategoryService;
import com.example.tlstore.services.IProductImageService;
import com.example.tlstore.services.IProductService;
import com.example.tlstore.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    IProductImageService iProductImageService;

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> listProduct = iProductService.getAllProducts();
        if (listProduct.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }
    @GetMapping("/best-selling")
    public ResponseEntity<List<ProductDto>> getTop10BestSelling() {
        List<ProductDto> listProduct = iProductService.getTop10ProductBySold();
        if (listProduct.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }
    @GetMapping("/new")
    public ResponseEntity<List<ProductDto>> getTop10New() {
        List<ProductDto> listProduct = iProductService.getTop10NewProducts();
        if (listProduct.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") long id) {
        ProductDto Product = iProductService.getProductById(id);
        return new ResponseEntity<>(Product, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        CategoryDto categoryDto = iCategoryService.getCategoryById(productDto.getCategory().getId());
        productDto.setCategory(categoryDto);
        List<ProductImageDto> images = new ArrayList<>();
        if(productDto.getProductImages() != null)
        {
            images = productDto.getProductImages();
        }
        productDto.setProductImages(null);
        ProductDto savedProduct = iProductService.createProduct(productDto);

        // Add product image into product has been created
        List<ProductImageDto> newImages = new ArrayList<>();
        for (ProductImageDto image : images
        ) {
            ProductImageDto newOne = iProductImageService.addProductImage(image, savedProduct.getId());
            newImages.add(newOne);
        }
        ProductDto finalProduct = iProductService.getProductById(savedProduct.getId());
        finalProduct.setProductImages(newImages);
        return new ResponseEntity<>(finalProduct, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> patchProduct(@PathVariable("id") Long ProductId,
                                                   @RequestBody Map<Object, Object> ProductDto) {
        ProductDto updatedProduct = iProductService.patchProduct(ProductId, ProductDto);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long ProductId,
                                                    @RequestBody ProductDto productDto) {
        ProductDto updatedProduct = iProductService.updateProduct(ProductId, productDto);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long ProductId) {
        iProductService.deleteProduct(ProductId);
        return new ResponseEntity<>("Product successfully deleted !!", HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>> searchByName(@RequestParam("name") String name) {
        List<ProductDto> ProductDtos = iProductService.searchByProductName(name);
        return new ResponseEntity<>(ProductDtos, HttpStatus.OK);
    }
}
