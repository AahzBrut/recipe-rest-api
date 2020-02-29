package ru.aahzbrut.reciperestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Recipe;
import ru.aahzbrut.reciperestapi.dto.requests.RecipeRequest;
import ru.aahzbrut.reciperestapi.dto.responses.recipe.RecipeResponse;
import ru.aahzbrut.reciperestapi.mappers.RecipeMapper;
import ru.aahzbrut.reciperestapi.mappers.RecipeResponseMapper;
import ru.aahzbrut.reciperestapi.repositories.RecipeRepository;
import ru.aahzbrut.reciperestapi.services.RecipeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    private final RecipeResponseMapper recipeResponseMapper;
    private final RecipeMapper recipeMapper;

    @Override
    public RecipeResponse getById(Long recipeId) {
        return recipeResponseMapper.from(recipeRepository.getOne(recipeId));
    }

    @Override
    public void deleteById(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    @Override
    public List<RecipeResponse> getAllRecipes() {
        return recipeResponseMapper.from(recipeRepository.findAll());
    }

    @Override
    public RecipeResponse addNew(RecipeRequest recipeRequest) {

        Recipe recipe = recipeMapper.from(recipeRequest);

        recipe = recipeRepository.saveAndFlush(recipe);

        return recipeResponseMapper.from(recipe);
    }

    @Override
    public RecipeResponse update(Long recipeId, RecipeRequest recipeRequest) {

        Recipe recipe = recipeRepository.getOne(recipeId);

        recipe = recipeMapper.merge(recipe, recipeRequest);

        recipe = recipeRepository.saveAndFlush(recipe);

        return recipeResponseMapper.from(recipe);
    }
}
