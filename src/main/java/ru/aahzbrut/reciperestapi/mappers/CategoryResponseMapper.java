package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.responses.category.CategoryResponse;

public interface CategoryResponseMapper {

    CategoryResponse from(Category category);
}
