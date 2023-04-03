package com.example.tlstore.dtos;

import com.example.tlstore.entities.Product;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageDto {

    private long id;

    private String image;

    private Product product;
}
