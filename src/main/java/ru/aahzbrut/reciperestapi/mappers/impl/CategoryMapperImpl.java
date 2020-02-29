package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.mappers.CategoryMapper;

@Service
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category from(CategoryRequest categoryRequest) {
        return merge(new Category(), categoryRequest);
    }

    @Override
    public Category merge(Category category, CategoryRequest categoryRequest) {
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());

        return category;
    }

}
