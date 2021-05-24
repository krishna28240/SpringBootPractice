package com.javathought.product.catalog.serviceImpl;

import com.javathought.product.catalog.dto.CategoryAttributesCatalog;
import com.javathought.product.catalog.dto.CategoryAttributesDto;
import com.javathought.product.catalog.dto.CategoryDto;
import com.javathought.product.catalog.entity.Category;
import com.javathought.product.catalog.entity.CategoryAttributes;
import com.javathought.product.catalog.repository.CategoryAttributesRepository;
import com.javathought.product.catalog.repository.CategoryRepository;
import com.javathought.product.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryAttributesRepository categoryAttributesRepository;

    @Override
    public Category addCategory(CategoryDto categoryDto) {
        Category c=null;
        if(categoryDto.getCategoryName()!=null) {
            Category findExists = categoryRepository.findByName(categoryDto.getCategoryName());
            if(findExists==null) {
                Category category = new Category();
                category.setName(categoryDto.getCategoryName());
                c = categoryRepository.save(category);
            }{
                return c;
            }
        }
        return c;
    }
    @Override
    @Transactional
    public void addCategoryAttributes(CategoryAttributesCatalog categoryAttributesCatalog) {
        Category findCategory = categoryRepository.findByName(categoryAttributesCatalog.getCategory().getCategoryName());
        if (findCategory!=null && findCategory.getId()!=null) {
            categoryAttributesRepository.deleteByCategoryId(findCategory.getId());
            List<CategoryAttributes> saveAll=new ArrayList<>();
            for (CategoryAttributesDto categoryAttributes : categoryAttributesCatalog.getCategoryAttributes()) {
                CategoryAttributes categoryAttributes1 = new CategoryAttributes();
                categoryAttributes1.setAttributeName(categoryAttributes.getAttributeName());
                categoryAttributes1.setAttributeValue(categoryAttributes.getAttributeValue());
                categoryAttributes1.setCategoryId(findCategory.getId());
                saveAll.add(categoryAttributes1);
            }
            categoryAttributesRepository.saveAll(saveAll);
        }else{
            //TODO No category to create attributes
        }
    }

    @Override
    public Category findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public CategoryAttributesCatalog findAllByCategoryId(Long categoryId) {
        CategoryAttributesCatalog categoryAttributesCatalog =new CategoryAttributesCatalog();
        Optional<Category> findCategory = categoryRepository.findById(categoryId);
        if(findCategory.isPresent()){
            CategoryDto category =new CategoryDto();
            category.setId(findCategory.get().getId());
            category.setCategoryName(findCategory.get().getName());
            categoryAttributesCatalog.setCategory(category);

            //
            List<CategoryAttributes> categoryAttributes = categoryAttributesRepository.
                    findAllByCategoryId(findCategory.get().getId());
            if (categoryAttributes != null && !categoryAttributes.isEmpty()) {
                List<CategoryAttributesDto> categoryAttributesList = new ArrayList<>();
                for (CategoryAttributes aCat : categoryAttributes) {
                    CategoryAttributesDto categoryAttributesDto = new CategoryAttributesDto();
                    categoryAttributesDto.setAttributeId(aCat.getAttributeId());
                    categoryAttributesDto.setAttributeName(aCat.getAttributeName());
                    categoryAttributesDto.setAttributeValue(aCat.getAttributeValue());
                    categoryAttributesList.add(categoryAttributesDto);
                }
                categoryAttributesCatalog.setCategoryAttributes(categoryAttributesList);
            }
        }
        return categoryAttributesCatalog;
    }

    @Override
    public Optional<Category> findById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

}
