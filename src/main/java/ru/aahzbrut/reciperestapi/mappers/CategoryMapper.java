package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;

public interface CategoryMapper {

    Category from(CategoryRequest categoryRequest);

    Category merge(Category category, CategoryRequest categoryRequest);
}
