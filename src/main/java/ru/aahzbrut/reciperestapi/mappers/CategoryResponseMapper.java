package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.responses.category.CategoryResponse;

import java.util.List;

public interface CategoryResponseMapper {

    CategoryResponse from(Category category);

    List<CategoryResponse> from(List<Category> categories);
}
