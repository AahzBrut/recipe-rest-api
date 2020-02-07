package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Ingredient;
import ru.aahzbrut.reciperestapi.dto.requests.IngredientRequest;
import ru.aahzbrut.reciperestapi.mappers.IngredientMapper;

@Service
public class IngredientMapperImpl implements IngredientMapper {

    @Override
    public Ingredient from(IngredientRequest ingredientRequest) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientRequest.getName());
        ingredient.setDescription(ingredientRequest.getDescription());

        return ingredient;
    }
}
