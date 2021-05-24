package com.javathought.product.catalog.controller;

import com.javathought.product.catalog.dto.CategoryAttributesCatalog;
import com.javathought.product.catalog.dto.CategoryDto;
import com.javathought.product.catalog.dto.CatalogResponse;
import com.javathought.product.catalog.entity.Category;
import com.javathought.product.catalog.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/")
public class CategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    CategoryService categoryService;

    @PostMapping("/category")
    @ResponseBody
    public ResponseEntity addCategory(@RequestBody CategoryDto category){
         Category categoryResponse = categoryService.addCategory(category);
         if(categoryResponse==null) {
             CatalogResponse response = new CatalogResponse();
             response.setStatus("Category Exists!");
             return ResponseEntity.ok(response);
         }else{
             return ResponseEntity.ok(categoryResponse);
         }
    }
    @PostMapping("/categoryAttributes")
    @ResponseBody
    public void addCategoryAttributes(@RequestBody CategoryAttributesCatalog categoryAtrAttributesDto){
        categoryService.addCategoryAttributes(categoryAtrAttributesDto);
    }

    @GetMapping("/categoryAttributes/byCategoryId/{categoryId}")
    @ResponseBody
    public ResponseEntity getCategoryAttributesByCategoryId(@PathVariable  Long categoryId){
        Optional<Category> category = categoryService.findById(categoryId);
        CategoryAttributesCatalog categoryAttributesCatalog = null;
        if(!category.isPresent()) {
            CatalogResponse response = new CatalogResponse();
            response.setStatus("Category Not Exists!");
            return ResponseEntity.ok(response);
        }else{
            categoryAttributesCatalog = categoryService.findAllByCategoryId(category.get().getId());
        }
        return ResponseEntity.ok(categoryAttributesCatalog);
    }

}
