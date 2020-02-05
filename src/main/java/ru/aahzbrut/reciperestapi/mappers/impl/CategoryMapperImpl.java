package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.mappers.CategoryMapper;

@Service
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category from(CategoryRequest categoryRequest) {

        Category result = new Category();
        result.setName(categoryRequest.getName());
        result.setDescription(categoryRequest.getDescription());

        return result;
    }
}
