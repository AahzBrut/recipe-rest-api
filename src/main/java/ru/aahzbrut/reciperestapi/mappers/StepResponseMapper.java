package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.Step;
import ru.aahzbrut.reciperestapi.dto.responses.step.StepResponse;

import java.util.List;

public interface StepResponseMapper {

    StepResponse from(Step step);

    List<StepResponse> from(List<Step> steps);
}
