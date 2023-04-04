package com.example.tlstore.repositories;

import com.example.tlstore.entities.Category;
import com.example.tlstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductNameContainingIgnoreCase(String name);
    List<Product> findByProductNameContainingAndCategoryAllIgnoreCase(String productName, Category category);
    List<Product> findTop10ByOrderBySoldDesc();
    List<Product> findTop10ByOrderByCreateAtDesc();
}
