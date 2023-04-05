package com.example.tlstore.repositories;

import com.example.tlstore.entities.Cart;
import com.example.tlstore.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUserId(Long UserId);
    int countByUserId(Long UserId);
}
