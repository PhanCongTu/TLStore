package com.example.tlstore.repositories;

import com.example.tlstore.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    Optional<ProductImage> findById(Long productImageId);
    List<ProductImage> findAllByProductId(Long productId);
}
