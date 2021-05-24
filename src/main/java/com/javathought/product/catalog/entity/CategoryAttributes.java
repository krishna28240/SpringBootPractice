package com.javathought.product.catalog.entity;

import javax.persistence.*;

@Entity
@Table(name="category_attributes")
public class CategoryAttributes {
    //attribute_id, attribute_name, attribute_value, category_id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="attribute_id")
    private Long attributeId;
    @Column(name = "attribute_name")
    private String attributeName;
    @Column(name = "attribute_value")
    private String attributeValue;
    @Column(name = "category_id")
    private Long categoryId;
    public CategoryAttributes(){

    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


}
