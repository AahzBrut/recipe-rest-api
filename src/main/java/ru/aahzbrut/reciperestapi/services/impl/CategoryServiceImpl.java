package ru.aahzbrut.reciperestapi.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.dto.responses.CategoryResponse;
import ru.aahzbrut.reciperestapi.exceptions.NotImplementedException;
import ru.aahzbrut.reciperestapi.mappers.CategoryMapper;
import ru.aahzbrut.reciperestapi.repositories.CategoryRepository;
import ru.aahzbrut.reciperestapi.services.CategoryService;

import java.util.List;

import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse getById(Long categoryId) {
        log.debug("IN: " + getCurrentMethodName());

        Category category = categoryRepository.getOne(categoryId);
        log.trace("Category with ID:" + categoryId + " - " + category);

        CategoryResponse response = categoryMapper.categoryToCategoryResponse(category);
        log.trace("CategoryResponse with ID:" + categoryId + " - " + response);

        log.debug("OUT: " + getCurrentMethodName());
        return response;
    }

    @Override
    public CategoryResponse save(CategoryRequest categoryRequest) {
        log.debug("IN: " + getCurrentMethodName());

        Category categoryEntity = categoryMapper.categoryRequestToCategory(categoryRequest);
        log.trace("Category before save: " + categoryEntity.toString());

        categoryEntity = categoryRepository.save(categoryEntity);
        log.trace("Category after save: " + categoryEntity.toString());

        CategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(categoryEntity);
        log.trace("CategoryResponse: " + categoryResponse);

        log.debug("OUT: " + getCurrentMethodName());
        return categoryResponse;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        throw new NotImplementedException();
    }

    @Override
    public void deleteById(Long categoryId) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isCategoryExists(CategoryRequest categoryRequest) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isCategoryExists(Long categoryId) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(CategoryRequest categoryRequest) {
        throw new NotImplementedException();
    }
}

