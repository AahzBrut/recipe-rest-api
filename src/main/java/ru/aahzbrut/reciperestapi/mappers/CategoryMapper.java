package ru.aahzbrut.reciperestapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.dto.responses.CategoryResponse;

@Mapper
public interface CategoryMapper {

    CategoryResponse from(Category category);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdDateTime", ignore = true),
            @Mapping(target = "updatedDateTime", ignore = true),
            @Mapping(target = "recipes", ignore = true)})
    Category from(CategoryRequest categoryRequest);
}
