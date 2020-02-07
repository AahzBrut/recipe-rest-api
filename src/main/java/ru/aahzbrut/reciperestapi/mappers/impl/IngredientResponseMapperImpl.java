package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Ingredient;
import ru.aahzbrut.reciperestapi.dto.responses.IngredientResponse;
import ru.aahzbrut.reciperestapi.mappers.IngredientResponseMapper;

@Service
public class IngredientResponseMapperImpl implements IngredientResponseMapper {

    @Override
    public IngredientResponse from(Ingredient ingredient) {
        IngredientResponse ingredientResponse = new IngredientResponse();
        ingredientResponse.setId(ingredient.getId());
        ingredientResponse.setName(ingredient.getName());
        ingredientResponse.setDescription(ingredient.getDescription());
        ingredientResponse.setCreatedDateTime(ingredient.getCreatedDateTime());
        ingredientResponse.setUpdatedDateTime(ingredient.getModifiedDateTime());

        return ingredientResponse;
    }
}
