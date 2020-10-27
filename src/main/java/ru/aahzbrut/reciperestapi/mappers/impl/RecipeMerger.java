package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Recipe;
import ru.aahzbrut.reciperestapi.dto.requests.RecipeRequest;
import ru.aahzbrut.reciperestapi.mappers.Merger;

@Service
public class RecipeMerger implements Merger<Recipe, RecipeRequest> {

    @Override
    public Recipe merge(Recipe source1, RecipeRequest source2) {

        return source1
                .setName(source2.getName())
                .setDescription(source2.getDescription())
                .setDifficulty(source2.getDifficulty())
                .setUrl(source2.getUrl())
                .setImage(source2.getImage())
                .setNumServings(source2.getNumServings())
                .setSource(source2.getSource());
    }
}
