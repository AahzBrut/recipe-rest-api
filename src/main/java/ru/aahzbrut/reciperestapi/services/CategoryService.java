package ru.aahzbrut.reciperestapi.services;

import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.dto.responses.category.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getById(Long categoryId);
    CategoryResponse create(CategoryRequest categoryRequest);
    List<CategoryResponse> getAllCategories();
    void delete(CategoryRequest categoryRequest);
    void deleteById(Long categoryId);
    boolean isCategoryExists(CategoryRequest categoryRequest);
    CategoryResponse update(Long categoryId, CategoryRequest categoryRequest);
}
