package ru.aahzbrut.reciperestapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.responses.CategoryResponse;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryResponse categoryToCategoryResponse(Category category);
}
