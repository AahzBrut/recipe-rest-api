package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.Step;
import ru.aahzbrut.reciperestapi.dto.requests.StepRequest;

public interface StepMapper {

    Step from(StepRequest stepRequest);

    Step merge(Step step, StepRequest stepRequest);
}
