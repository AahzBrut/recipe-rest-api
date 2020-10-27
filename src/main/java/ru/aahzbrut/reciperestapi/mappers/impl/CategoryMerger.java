package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.mappers.Merger;

@Service
public class CategoryMerger implements Merger<Category, CategoryRequest> {

    @Override
    public Category merge(Category source1, CategoryRequest source2) {
        return source1
                .setName(source2.getName())
                .setDescription(source2.getDescription());
    }
}
