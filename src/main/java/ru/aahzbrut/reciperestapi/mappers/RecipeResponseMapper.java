package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.Recipe;
import ru.aahzbrut.reciperestapi.dto.responses.recipe.RecipeResponse;

import java.util.List;

public interface RecipeResponseMapper {

    RecipeResponse from(Recipe recipe);

    List<RecipeResponse> from(List<Recipe> recipes);
}
