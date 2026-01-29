package com.example.tutoAPI.product.mapper;

import com.example.tutoAPI.product.dto.CategoryRequest;
import com.example.tutoAPI.product.dto.CategoryResponse;
import com.example.tutoAPI.product.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {


    public Category toCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.name());
        return category;
    }


    public CategoryResponse toCategoryResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse(
                category.getId(),
                category.getName()
        );
        return categoryResponse;
    }
}
