package com.javathought.product.catalog.dto;

import java.util.List;

public class CategoryAttributesCatalog {
    private CategoryDto category;
    private List<CategoryAttributesDto> categoryAttributes;
    public CategoryAttributesCatalog(){

    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public List<CategoryAttributesDto> getCategoryAttributes() {
        return categoryAttributes;
    }

    public void setCategoryAttributes(List<CategoryAttributesDto> categoryAttributes) {
        this.categoryAttributes = categoryAttributes;
    }
}
