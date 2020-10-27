package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.responses.category.CategoryResponse;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

@Service
public class CategoryResponseMapper implements Mapper<CategoryResponse, Category> {

    @Override
    public CategoryResponse from(Category source) {

        return new CategoryResponse()
                .setId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreatedDateTime(source.getCreatedDateTime())
                .setUpdatedDateTime(source.getModifiedDateTime());
    }

}
