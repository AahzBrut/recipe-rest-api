package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.responses.category.CategoryResponse;
import ru.aahzbrut.reciperestapi.mappers.CategoryResponseMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryResponseMapperImpl implements CategoryResponseMapper {

    @Override
    public CategoryResponse from(Category category) {

        CategoryResponse result = new CategoryResponse();
        result.setId(category.getId());
        result.setName(category.getName());
        result.setDescription(category.getDescription());
        result.setCreatedDateTime(category.getCreatedDateTime());
        result.setUpdatedDateTime(category.getModifiedDateTime());

        return result;
    }

    @Override
    public List<CategoryResponse> from(List<Category> categories) {
        return categories
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
}
