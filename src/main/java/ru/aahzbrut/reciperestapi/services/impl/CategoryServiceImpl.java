package ru.aahzbrut.reciperestapi.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Category;
import ru.aahzbrut.reciperestapi.exceptions.NotImplementedException;
import ru.aahzbrut.reciperestapi.repositories.CategoryRepository;
import ru.aahzbrut.reciperestapi.services.CategoryService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public boolean isCategoryExists(Category category) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isCategoryExists(Long categoryId) {
        throw new NotImplementedException();
    }

    @Override
    public List<Category> getAll() {
        throw new NotImplementedException();
    }

    @Override
    public Category getById(Long categoryId) {

        return categoryRepository.getOne(categoryId);
    }

    @Override
    public Category save(Category category) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Category category) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteById(Long categoryId) {
        throw new NotImplementedException();
    }
}

