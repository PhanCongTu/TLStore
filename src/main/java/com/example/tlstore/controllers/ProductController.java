package com.example.tlstore.controllers;

import com.example.tlstore.dtos.CategoryDto;
import com.example.tlstore.dtos.ProductDto;
import com.example.tlstore.dtos.ProductDto;
import com.example.tlstore.dtos.ProductPagination;
import com.example.tlstore.entities.Category;
import com.example.tlstore.services.ICategoryService;
import com.example.tlstore.services.IProductService;
import com.example.tlstore.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> listProduct = iProductService.getAllProducts();
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
        ProductDto savedProduct = iProductService.createProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> patchProduct(@PathVariable("id") Long ProductId,
                                                     @RequestBody Map<Object, Object> ProductDto) {
        ProductDto updatedProduct = iProductService.patchProduct(ProductId , ProductDto);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long ProductId){
        iProductService.deleteProduct(ProductId);
        return new ResponseEntity<>("Product successfully deleted !!", HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>> searchByName(@RequestParam("name") String name){
        List<ProductDto> ProductDtos = iProductService.searchByProductName(name);
        return new ResponseEntity<>(ProductDtos, HttpStatus.OK);
    }
}
