package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Ingredient;
import ru.aahzbrut.reciperestapi.dto.responses.ingredient.IngredientResponse;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

@Service
public class IngredientResponseMapper implements Mapper<IngredientResponse, Ingredient> {

    @Override
    public IngredientResponse from(Ingredient source) {

        return new IngredientResponse()
                .setId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreatedDateTime(source.getCreatedDateTime())
                .setUpdatedDateTime(source.getModifiedDateTime());
    }
}
