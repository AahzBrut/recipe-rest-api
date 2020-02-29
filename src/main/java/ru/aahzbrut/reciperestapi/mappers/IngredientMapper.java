package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.Ingredient;
import ru.aahzbrut.reciperestapi.dto.requests.IngredientRequest;

public interface IngredientMapper {

    Ingredient from(IngredientRequest ingredientRequest);

    Ingredient merge(Ingredient ingredient, IngredientRequest ingredientRequest);
}
