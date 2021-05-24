package com.javathought.product.catalog.serviceImpl;

import com.javathought.product.catalog.Util;
import com.javathought.product.catalog.dto.CatalogResponse;
import com.javathought.product.catalog.dto.CategoryAttributesDto;
import com.javathought.product.catalog.dto.ProductDto;
import com.javathought.product.catalog.entity.Category;
import com.javathought.product.catalog.entity.CategoryAttributes;
import com.javathought.product.catalog.entity.Product;
import com.javathought.product.catalog.repository.CategoryAttributesRepository;
import com.javathought.product.catalog.repository.CategoryRepository;
import com.javathought.product.catalog.repository.ProductRepository;
import com.javathought.product.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryAttributesRepository categoryAttributesRepository;
    @Override
    public Product addProduct(ProductDto productDto, Long categoryID) {
        Product product = null;
        if(productDto.getProductName()!=null){
            product = new Product();
            product.setProductName(productDto.getProductName());
            product.setProductId(Util.getRandomString());
            product.setCategoryId(categoryID);
            product.setCategoryName(productDto.getCategoryName());
            product.setUnitPrice(productDto.getUnitPrice()==null?0.0:productDto.getUnitPrice());
            product.setQuantityPerUnit(productDto.getQuantityPerUnit()==null?0:productDto.getQuantityPerUnit());
            if(productDto.getUnitPrice()!=null && productDto.getQuantityPerUnit()!=null) {
                product.setTotalCost((productDto.getUnitPrice() * productDto.getQuantityPerUnit()));
            }
            product = productRepository.save(product);
        }
        return product;
    }

    @Override
    public ProductDto findByProductId(String productId) {
        ProductDto productDto = new ProductDto();
        Product product = productRepository.findByProductId(productId);
        if (product !=null) {
            //TODO-get the categoryID to find categoryAttributes to display in product
            List<CategoryAttributes> categoryAttributes = categoryAttributesRepository.
                    findAllByCategoryId(product.getCategoryId());
            if (categoryAttributes != null && !categoryAttributes.isEmpty()) {
                List<CategoryAttributesDto> categoryAttributesList = new ArrayList<>();
                for (CategoryAttributes aCat : categoryAttributes) {
                    CategoryAttributesDto categoryAttributesDto = new CategoryAttributesDto();
                    categoryAttributesDto.setAttributeId(aCat.getAttributeId());
                    categoryAttributesDto.setAttributeName(aCat.getAttributeName());
                    categoryAttributesDto.setAttributeValue(aCat.getAttributeValue());
                    categoryAttributesList.add(categoryAttributesDto);
                }
                productDto.setProductId(product.getProductId());
                productDto.setProductName(product.getProductName());
                productDto.setCategoryId(product.getCategoryId());
                productDto.setCategoryName(product.getCategoryName());
                productDto.setUnitPrice(product.getUnitPrice());
                productDto.setQuantityPerUnit(product.getQuantityPerUnit());
                productDto.setTotalCost(product.getTotalCost());
                productDto.setCategoryAttributes(categoryAttributesList);
            }
        }else{
            //TODO--No Product Found
        }
        return productDto;
    }
}
