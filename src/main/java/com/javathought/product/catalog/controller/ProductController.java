package com.javathought.product.catalog.controller;

import com.javathought.product.catalog.dto.CatalogResponse;
import com.javathought.product.catalog.dto.ProductDto;
import com.javathought.product.catalog.entity.Category;
import com.javathought.product.catalog.entity.Product;
import com.javathought.product.catalog.repository.ProductRepository;
import com.javathought.product.catalog.service.CategoryService;
import com.javathought.product.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/product")
    @ResponseBody
    public ResponseEntity addCategory(@RequestBody ProductDto productDto){
        Product productResponse = null;
        Category findCategory = categoryService.findByName(productDto.getCategoryName());
        if(findCategory!=null && findCategory.getId()!=null) {
             productResponse = productService.addProduct(productDto, findCategory.getId());
        }else{
            CatalogResponse response = new CatalogResponse();
            response.setStatus("Product Category doesn't Exists!");
            return ResponseEntity.ok(response);
        }
        if(productResponse==null) {
            CatalogResponse response = new CatalogResponse();
            response.setStatus("Product Exists!");
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.ok(productResponse);
        }
    }
    @GetMapping("/product/byId/{productId}")
    @ResponseBody
    public ResponseEntity getProduct(@PathVariable String productId){
        Product product = productRepository.findByProductId(productId);
        if(product==null) {
            CatalogResponse response = new CatalogResponse();
            response.setStatus("Product not found!");
            return ResponseEntity.ok(response);
        }else{
            ProductDto productResponse = productService.findByProductId(productId);
            return ResponseEntity.ok(productResponse);
        }
    }
}
