package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Ingredient;
import ru.aahzbrut.reciperestapi.dto.requests.IngredientRequest;
import ru.aahzbrut.reciperestapi.mappers.Merger;

@Service
public class IngredientMerger implements Merger<Ingredient, IngredientRequest> {

    @Override
    public Ingredient merge(Ingredient source1, IngredientRequest source2) {

        return source1
                .setName(source2.getName())
                .setDescription(source2.getDescription());
    }
}
