package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

@Service
public class CategoryMapper implements Mapper<Category, CategoryRequest> {

    @Override
    public Category from(CategoryRequest source) {

        return new Category()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
