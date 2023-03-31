package com.example.tlstore.dtos;

import com.example.tlstore.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private long id ;
    private String name;
    private String image;
    private Boolean isDeleted;
}
