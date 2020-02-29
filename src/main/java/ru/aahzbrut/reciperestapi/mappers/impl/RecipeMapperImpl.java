package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Recipe;
import ru.aahzbrut.reciperestapi.dto.requests.RecipeRequest;
import ru.aahzbrut.reciperestapi.mappers.RecipeMapper;

@Service
public class RecipeMapperImpl implements RecipeMapper {

    @Override
    public Recipe from(RecipeRequest recipeRequest) {
        Recipe result = new Recipe();

        return merge(result, recipeRequest);
    }

    @Override
    public Recipe merge(Recipe recipe, RecipeRequest recipeRequest) {
        recipe.setName(recipeRequest.getName());
        recipe.setDescription(recipeRequest.getDescription());
        recipe.setNumServings(recipeRequest.getNumServings());
        recipe.setDifficulty(recipeRequest.getDifficulty());
        recipe.setImage(recipeRequest.getImage());
        recipe.setUrl(recipeRequest.getUrl());
        recipe.setSource(recipeRequest.getSource());

        return recipe;
    }
}
