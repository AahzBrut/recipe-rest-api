package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.StepIngredient;
import ru.aahzbrut.reciperestapi.dto.responses.step.StepIngredientResponse;

import java.util.List;

public interface StepIngredientResponseMapper {

    StepIngredientResponse from(StepIngredient stepIngredient);

    List<StepIngredientResponse> from(List<StepIngredient> stepIngredients);
}
