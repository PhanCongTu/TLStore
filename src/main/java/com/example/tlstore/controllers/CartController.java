package com.example.tlstore.controllers;

import com.example.tlstore.dtos.CartDto;
import com.example.tlstore.dtos.ProductDto;
import com.example.tlstore.repositories.CartRepository;
import com.example.tlstore.services.ICartService;
import com.example.tlstore.services.IProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    ICartService iCartService;
    @Autowired
    IProductService iproductService;
    @Autowired
    CartRepository cartRepository;

    @GetMapping("")
    @ApiOperation(value = "Get all Cart of User")
    public ResponseEntity<List<CartDto>> getAllCart(Long userId) {
        List<CartDto> listCart = iCartService.getAllCartByUserId(userId);
        if (listCart.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listCart, HttpStatus.OK);
    }

    @ApiOperation(value = "Add cart")
    @PostMapping
    public ResponseEntity<CartDto> createCart(Long productId, Long userId, int quantity) {
        ProductDto productDto = iproductService.getProductById(productId);
        CartDto newCartDto = new CartDto();
        newCartDto.setQuantity(quantity);
        newCartDto.setProduct(productDto);
        CartDto savedCartDto = iCartService.addCart(newCartDto, userId);
        return new ResponseEntity<>(savedCartDto, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update Cart (Update quantity of product in cart)")
    @PutMapping("/update")
    public ResponseEntity<CartDto> updateCart(Long cartId, int quantity) {
        CartDto newCartDto = iCartService.updateCart(cartId,quantity);
        return new ResponseEntity<>(newCartDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Deleted Cart (Deleted quantity of product in cart)")
    @DeleteMapping("")
    public ResponseEntity<String> deleteCategory(Long cartId) {
        cartRepository.deleteById(cartId);
        return new ResponseEntity<>("Deleted successfully!!", HttpStatus.OK);
    }

    @ApiOperation(value = "Lấy sổ lượng cart của user")
    @GetMapping("/count/{userId}")
    public ResponseEntity<Integer> countAllCart(Long userId){
        return new ResponseEntity<>(iCartService.countAllCartByUserId(userId), HttpStatus.OK);
    }

}
