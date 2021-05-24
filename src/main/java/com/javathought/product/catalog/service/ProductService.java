package com.javathought.product.catalog.service;

import com.javathought.product.catalog.dto.ProductDto;
import com.javathought.product.catalog.entity.Product;

public interface ProductService {
    public Product addProduct(ProductDto productDto, Long categoryId);

    ProductDto findByProductId(String productId);
}
