package ru.aahzbrut.reciperestapi.services;

import ru.aahzbrut.reciperestapi.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    Category getById(Long categoryId);
    Category save(Category category);
    List<Category> getAll();
    void delete(Category category);
    void deleteById(Long categoryId);
    boolean isCategoryExists(Category category);
    boolean isCategoryExists(Long categoryId);
}
