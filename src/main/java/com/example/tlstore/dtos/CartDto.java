package com.example.tlstore.dtos;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private long id;

    private int quantity;

    private ProductDto product;
}
