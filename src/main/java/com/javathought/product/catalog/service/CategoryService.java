package com.javathought.product.catalog.service;

import com.javathought.product.catalog.dto.CategoryAttributesCatalog;
import com.javathought.product.catalog.dto.CategoryAttributesDto;
import com.javathought.product.catalog.dto.CategoryDto;
import com.javathought.product.catalog.entity.Category;
import com.javathought.product.catalog.entity.CategoryAttributes;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CategoryService {
    public Category addCategory(CategoryDto categoryDto);
    public void addCategoryAttributes(CategoryAttributesCatalog categoryAttributesDto);
    public Category findByName(String categoryName);
    public CategoryAttributesCatalog findAllByCategoryId(Long categoryId);
    public Optional<Category> findById(Long categoryId);
}
