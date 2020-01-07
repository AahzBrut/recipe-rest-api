package ru.aahzbrut.reciperestapi.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.dto.responses.CategoryResponse;
import ru.aahzbrut.reciperestapi.mappers.CategoryMapper;
import ru.aahzbrut.reciperestapi.repositories.CategoryRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    private static final Long categoryId = 1L;
    private static final String categoryName = "Category one";
    private static final String categoryDescription = "The first category";
    private static final LocalDateTime createdDateTime = LocalDateTime.now();
    private static final LocalDateTime updatedDateTime = LocalDateTime.now();

    Category categoryEntity;

    CategoryRequest categoryRequest;

    @Mock
    CategoryRepository categoryRepository;

    @SuppressWarnings("unused")
    @Spy
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @InjectMocks
    CategoryServiceImpl categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(categoryService);

        categoryEntity = Category.builder()
                .id(categoryId)
                .name(categoryName)
                .description(categoryDescription)
                .createdDateTime(createdDateTime)
                .updatedDateTime(updatedDateTime)
                .build();

        categoryRequest = new CategoryRequest();
        categoryRequest.setName(categoryName);
        categoryRequest.setDescription(categoryDescription);

    }

    @Test
    void getById() {

        //given
        when(categoryRepository.getOne(categoryId)).thenReturn(categoryEntity);

        //when
        CategoryResponse response = categoryService.getById(categoryId);

        //then
        assertEquals(categoryId, response.getId());
        assertEquals(categoryName, response.getName());
        assertEquals(categoryDescription, response.getDescription());
        assertEquals(createdDateTime, response.getCreatedDateTime());
        assertEquals(updatedDateTime, response.getUpdatedDateTime());
    }

    @Test
    void save() {
        //given
        when(categoryRepository.save(any(Category.class))).thenReturn(categoryEntity);

        //when
        CategoryResponse response = categoryService.save(categoryRequest);

        //then
        assertEquals(categoryId, response.getId());
        assertEquals(categoryName, response.getName());
        assertEquals(categoryDescription, response.getDescription());
        assertEquals(createdDateTime, response.getCreatedDateTime());
        assertEquals(updatedDateTime, response.getUpdatedDateTime());
    }

    @Test
    void getAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void isCategoryExists() {
    }

    @Test
    void testIsCategoryExists() {
    }
}