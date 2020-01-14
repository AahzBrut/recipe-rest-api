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
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    private static final Long categoryId = 1L;
    private static final String categoryName = "Category one";
    private static final String nonExistCategoryName = "Category two";
    private static final String categoryDescription = "The first category";
    private static final LocalDateTime createdDateTime = LocalDateTime.now();
    private static final LocalDateTime updatedDateTime = LocalDateTime.now();
    private static final int EXPECTED_ALL_SIZE = 2;

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

        categoryEntity = new Category();
        categoryEntity.setId(categoryId);
        categoryEntity.setName(categoryName);
        categoryEntity.setDescription(categoryDescription);
        categoryEntity.setCreatedDateTime(createdDateTime);
        categoryEntity.setUpdatedDateTime(updatedDateTime);

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

        verify(categoryRepository, times(1)).getOne(categoryId);
        verify(categoryMapper, times(1)).categoryToCategoryResponse(any());
        verifyNoMoreInteractions(categoryRepository);
        verifyNoMoreInteractions(categoryMapper);
    }

    @Test
    void save() {
        //given
        when(categoryRepository.saveAndFlush(any())).thenReturn(categoryEntity);

        //when
        CategoryResponse response = categoryService.save(categoryRequest);

        //then
        assertEquals(categoryId, response.getId());
        assertEquals(categoryName, response.getName());
        assertEquals(categoryDescription, response.getDescription());
        assertEquals(createdDateTime, response.getCreatedDateTime());
        assertEquals(updatedDateTime, response.getUpdatedDateTime());

        verify(categoryRepository).saveAndFlush(any());
        verify(categoryMapper).categoryRequestToCategory(any());
        verify(categoryMapper).categoryToCategoryResponse(any());
        verifyNoMoreInteractions(categoryRepository);
        verifyNoMoreInteractions(categoryMapper);
    }

    @Test
    void getAll() {
        //given
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(categoryEntity, categoryEntity));

        //when
        List<CategoryResponse> response = categoryService.getAllCategories();

        //then
        assertEquals(EXPECTED_ALL_SIZE, response.size());

        assertEquals(categoryId, response.get(0).getId());
        assertEquals(categoryName, response.get(0).getName());
        assertEquals(categoryDescription, response.get(0).getDescription());
        assertEquals(createdDateTime, response.get(0).getCreatedDateTime());
        assertEquals(updatedDateTime, response.get(0).getUpdatedDateTime());

        assertEquals(categoryId, response.get(1).getId());
        assertEquals(categoryName, response.get(1).getName());
        assertEquals(categoryDescription, response.get(1).getDescription());
        assertEquals(createdDateTime, response.get(1).getCreatedDateTime());
        assertEquals(updatedDateTime, response.get(1).getUpdatedDateTime());

        verify(categoryRepository, times(1)).findAll();
        verify(categoryMapper, times(EXPECTED_ALL_SIZE)).categoryToCategoryResponse(any());
        verifyNoMoreInteractions(categoryRepository);
        verifyNoMoreInteractions(categoryMapper);
    }

    @Test
    void isCategoryExists() {
        //given
        when(categoryRepository.existsByName(categoryName)).thenReturn(true);
        when(categoryRepository.existsByName(nonExistCategoryName)).thenReturn(false);

        //when
        boolean assumeExist = categoryService.isCategoryExists(categoryRequest);
        categoryRequest.setName(nonExistCategoryName);
        boolean assumeNotExist = categoryService.isCategoryExists(categoryRequest);

        //then
        assertTrue(assumeExist);
        assertFalse(assumeNotExist);

        verify(categoryRepository, times(2)).existsByName(any());
        verifyNoMoreInteractions(categoryRepository);
        verifyNoInteractions(categoryMapper);
    }

    @Test
    void deleteById() {
        //given
        //when
        categoryService.deleteById(categoryId);
        //then
        verify(categoryRepository, times(1)).deleteById(categoryId);
        verifyNoMoreInteractions(categoryRepository);
    }

    @Test
    void delete() {
        //given
        //when
        categoryService.delete(categoryRequest);
        //then
        verify(categoryRepository, times(1)).deleteByName(categoryRequest.getName());
        verifyNoMoreInteractions(categoryRepository);
    }
}