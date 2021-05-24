package com.javathought.product.catalog.repository;

import com.javathought.product.catalog.entity.CategoryAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryAttributesRepository extends JpaRepository<CategoryAttributes, Long> {
    CategoryAttributes findByCategoryId(Long id);

    void deleteByCategoryId(Long id);

    List<CategoryAttributes> findAllByCategoryId(Long categoryId);

    //Optional<CategoryAttributes> findByName(String attributeName);
    /*@Modifying
    @Query("update CategoryAttributes u set u.attributeId = ?1, u.attributeName = ?2, u.attributeValue = ?3,  where u.categoryId = ?4")
    void updateAttributesByCategoryId(Long attributeId, String attributeName, String attributeValue, Long categoryId);
    */
}

