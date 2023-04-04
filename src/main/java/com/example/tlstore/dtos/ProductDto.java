package com.example.tlstore.dtos;

import com.example.tlstore.entities.Category;
import com.example.tlstore.entities.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private long id;
    private String productName;
    private int quantity;
    private int sold;
    private String description;
    private int price;
    private Boolean isActive = true;
    private CategoryDto category;
    private List<ProductImageDto> productImages;
}
