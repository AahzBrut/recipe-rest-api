package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.Recipe;
import ru.aahzbrut.reciperestapi.dto.requests.RecipeRequest;

public interface RecipeMapper {

    Recipe from(RecipeRequest recipeRequest);

    Recipe merge(Recipe recipe, RecipeRequest recipeRequest);
}
