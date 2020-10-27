package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Ingredient;
import ru.aahzbrut.reciperestapi.dto.requests.IngredientRequest;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

@Service
public class IngredientMapper implements Mapper<Ingredient, IngredientRequest> {

    @Override
    public Ingredient from(IngredientRequest source) {

        return new Ingredient()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
