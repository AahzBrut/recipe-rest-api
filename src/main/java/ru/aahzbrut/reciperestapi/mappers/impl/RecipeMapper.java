package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Recipe;
import ru.aahzbrut.reciperestapi.dto.requests.RecipeRequest;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

@Service
public class RecipeMapper implements Mapper<Recipe, RecipeRequest> {

    @Override
    public Recipe from(RecipeRequest source) {

        return new Recipe()
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setNumServings(source.getNumServings())
                .setDifficulty(source.getDifficulty())
                .setImage(source.getImage())
                .setUrl(source.getUrl());
    }
}