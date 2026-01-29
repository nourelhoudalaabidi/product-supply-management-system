package com.example.tutoAPI.product.service;


import com.example.tutoAPI.product.dto.CategoryRequest;
import com.example.tutoAPI.product.dto.CategoryResponse;
import com.example.tutoAPI.product.exceptions.CategoryException;
import com.example.tutoAPI.product.mapper.CategoryMapper;
import com.example.tutoAPI.product.model.Category;
import com.example.tutoAPI.product.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {

        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;

    }

    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toCategoryResponse).toList();

    }

    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryException("Category not found"));
        return categoryMapper.toCategoryResponse(category);
    }
    public CategoryResponse saveCategory(CategoryRequest category) {
        Category cat = categoryMapper.toCategory(category);
        Category savedCategory = categoryRepository.save(cat);
        return categoryMapper.toCategoryResponse(savedCategory);
    }

    public CategoryResponse updateCategory( Long id, CategoryRequest category) {
      Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        existingCategory.setName(category.name());
        Category updatedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.toCategoryResponse(updatedCategory);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);

    }
}
