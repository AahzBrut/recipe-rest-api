package ru.aahzbrut.reciperestapi.mappers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Recipe;
import ru.aahzbrut.reciperestapi.domain.entities.RecipeStep;
import ru.aahzbrut.reciperestapi.dto.responses.recipe.RecipeResponse;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeResponseMapper implements Mapper<RecipeResponse, Recipe> {

    private final NoteResponseMapper noteResponseMapper;
    private final StepResponseMapper stepResponseMapper;
    private final CategoryResponseMapper categoryResponseMapper;

    @Override
    public RecipeResponse from(Recipe recipe) {
        RecipeResponse result = new RecipeResponse();
        result.setId(recipe.getId());
        result.setName(recipe.getName());
        result.setDescription(recipe.getDescription());
        result.setDifficulty(recipe.getDifficulty());
        result.setSource(recipe.getSource());
        result.setUrl(recipe.getUrl());
        result.setImage(recipe.getImage());
        result.setNumServings(recipe.getNumServings());
        result.setNotes(noteResponseMapper.from(recipe.getNotes()));
        result.setSteps(stepResponseMapper.from(recipe.getRecipeSteps()
                .stream()
                .sorted(Comparator.comparingLong(RecipeStep::getOrdinal))
                .map(RecipeStep::getStep)
                .collect(Collectors.toList())));
        result.setCategories(categoryResponseMapper.from(recipe.getCategories()));
        result.setCreatedDateTime(recipe.getCreatedDateTime());
        result.setUpdatedDateTime(recipe.getModifiedDateTime());

        return result;
    }
}
