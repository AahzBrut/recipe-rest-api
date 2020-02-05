package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.mappers.CategoryRequestMapper;

@Service
public class CategoryRequestMapperImpl implements CategoryRequestMapper {

    @Override
    public CategoryRequest from(Category category) {

        CategoryRequest result = new CategoryRequest();
        result.setName(category.getName());
        result.setDescription(category.getDescription());

        return result;
    }
}
