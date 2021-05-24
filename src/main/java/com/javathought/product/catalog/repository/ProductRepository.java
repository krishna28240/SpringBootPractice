package com.javathought.product.catalog.repository;

import com.javathought.product.catalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByProductId(String productId);
}
