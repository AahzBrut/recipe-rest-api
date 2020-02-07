package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.Ingredient;
import ru.aahzbrut.reciperestapi.dto.responses.IngredientResponse;

public interface IngredientResponseMapper {

    IngredientResponse from(Ingredient ingredient);
}
