package ru.aahzbrut.reciperestapi.services;

import ru.aahzbrut.reciperestapi.dto.requests.RecipeRequest;
import ru.aahzbrut.reciperestapi.dto.responses.recipe.RecipeResponse;

import java.util.List;

public interface RecipeService {

    RecipeResponse getById(Long recipeId);

    void deleteById(Long recipeId);

    List<RecipeResponse> getAllRecipes();

    RecipeResponse addNew(RecipeRequest recipeRequest);

    RecipeResponse update(Long recipeId, RecipeRequest recipeRequest);
}
