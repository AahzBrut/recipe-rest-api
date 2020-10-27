package ru.aahzbrut.reciperestapi.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.dto.responses.category.CategoryResponse;
import ru.aahzbrut.reciperestapi.mappers.impl.CategoryMapper;
import ru.aahzbrut.reciperestapi.mappers.impl.CategoryMerger;
import ru.aahzbrut.reciperestapi.mappers.impl.CategoryResponseMapper;
import ru.aahzbrut.reciperestapi.repositories.CategoryRepository;
import ru.aahzbrut.reciperestapi.services.CategoryService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static ru.aahzbrut.reciperestapi.utils.DebugStrings.FINISH;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.START;
import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CategoryMerger categoryMerger;
    private final CategoryResponseMapper categoryResponseMapper;

    @Transactional
    @Override
    public CategoryResponse getById(Long categoryId) {
        log.debug(START + getCurrentMethodName());

        Category category = categoryRepository.getOne(categoryId);
        log.trace("Category with ID:" + categoryId + " - " + category);

        CategoryResponse response = categoryResponseMapper.from(category);
        log.trace("CategoryResponse with ID:" + categoryId + " - " + response);

        log.debug(FINISH + getCurrentMethodName());
        return response;
    }

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        log.debug(START + getCurrentMethodName());

        Category categoryEntity = categoryMapper.from(categoryRequest);
        log.trace("Category before save: " + categoryEntity.toString());

        categoryEntity = categoryRepository.saveAndFlush(categoryEntity);
        log.trace("Category after save: " + categoryEntity.toString());

        CategoryResponse categoryResponse = categoryResponseMapper.from(categoryEntity);
        log.trace("CategoryResponse: " + categoryResponse);

        log.debug(FINISH + getCurrentMethodName());
        return categoryResponse;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        log.debug(START + getCurrentMethodName());

        List<CategoryResponse> categories = categoryRepository.findAll().stream()
                .map(categoryResponseMapper::from)
                .collect(Collectors.toList());
        log.trace("Categories: " + categories);

        log.debug(FINISH + getCurrentMethodName());
        return categories;
    }

    @Override
    @Transactional
    public void deleteById(Long categoryId) {
        log.debug(START + getCurrentMethodName());

        categoryRepository.deleteById(categoryId);

        log.debug(FINISH + getCurrentMethodName());
    }

    @Override
    public boolean isCategoryExists(CategoryRequest categoryRequest) {
        log.debug(START + getCurrentMethodName());

        boolean result = categoryRepository.existsByName(categoryRequest.getName());
        log.trace("Category name '" + categoryRequest.getName() + (result ? "'" : "' not") + " found in repository.");

        log.debug(FINISH + getCurrentMethodName());
        return result;
    }

    @Transactional
    @Override
    public CategoryResponse update(Long categoryId, CategoryRequest categoryRequest) {
        log.debug(START + getCurrentMethodName());

        Category category = categoryRepository.getOne(categoryId);
        log.trace("Category before update: " + category);

        category = categoryMerger.merge(category, categoryRequest);
        log.trace("Category after update: " + category);

        category = categoryRepository.saveAndFlush(category);
        log.trace("Category after save: " + category);

        log.debug(FINISH + getCurrentMethodName());
        return categoryResponseMapper.from(category);
    }

    @Override
    @Transactional
    public void delete(CategoryRequest categoryRequest) {
        log.debug(START + getCurrentMethodName());

        categoryRepository.deleteByName(categoryRequest.getName());
        log.trace("Category with name '" + categoryRequest.getName() + "' was deleted from repository");

        log.debug(FINISH + getCurrentMethodName());
    }
}

