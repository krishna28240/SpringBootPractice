package com.javathought.product.catalog.dto;

public class CategoryDto {
    private Long id;
    private String categoryName;
    public CategoryDto(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
