package com.example.tlstore.dtos;


import com.example.tlstore.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private long id;

    private int quantity;

    private ProductDto product;
}
