package com.javathought.product.catalog.dto;

import java.util.List;

public class ProductDto {
    private String productId;
    private String productName;
    private Long categoryId;
    private String categoryName;
    private Integer quantityPerUnit;
    private Double unitPrice;
    private Double totalCost;
    private List<CategoryAttributesDto> categoryAttributes;
    public ProductDto() {
        // TODO Auto-generated constructor stub
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(Integer quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public List<CategoryAttributesDto> getCategoryAttributes() {
        return categoryAttributes;
    }

    public void setCategoryAttributes(List<CategoryAttributesDto> categoryAttributes) {
        this.categoryAttributes = categoryAttributes;
    }
}

