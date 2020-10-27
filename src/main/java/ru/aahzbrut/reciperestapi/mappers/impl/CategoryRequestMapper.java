package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

@Service
public class CategoryRequestMapper implements Mapper<CategoryRequest, Category> {

    @Override
    public CategoryRequest from(Category source) {

        return new CategoryRequest()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
