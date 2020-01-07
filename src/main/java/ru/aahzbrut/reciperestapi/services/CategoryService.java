package ru.aahzbrut.reciperestapi.services;

import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.dto.responses.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getById(Long categoryId);
    CategoryResponse save(CategoryRequest categoryRequest);
    List<CategoryResponse> getAllCategories();
    void delete(CategoryRequest categoryRequest);
    void deleteById(Long categoryId);
    boolean isCategoryExists(CategoryRequest categoryRequest);
    boolean isCategoryExists(Long categoryId);
}
