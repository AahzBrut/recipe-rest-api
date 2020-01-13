package ru.aahzbrut.reciperestapi.mappers;

import org.junit.jupiter.api.Test;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.responses.CategoryResponse;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryMapperTest {

    private static final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    private static final Long categoryId = 1L;
    private static final String categoryName = "Category one";
    private static final String categoryDescription = "The first category";
    private static final LocalDateTime createdDateTime = LocalDateTime.now();
    private static final LocalDateTime updatedDateTime = LocalDateTime.now();

    @Test
    void categoryToCategoryResponse() {

        //given
        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        category.setDescription(categoryDescription);
        category.setCreatedDateTime(createdDateTime);
        category.setUpdatedDateTime(updatedDateTime);

        //when
        CategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(category);

        //then
        assertEquals(categoryId, categoryResponse.getId());
        assertEquals(categoryName, categoryResponse.getName());
        assertEquals(categoryDescription, categoryResponse.getDescription());
        assertEquals(createdDateTime, categoryResponse.getCreatedDateTime());
        assertEquals(updatedDateTime, categoryResponse.getUpdatedDateTime());
    }
}