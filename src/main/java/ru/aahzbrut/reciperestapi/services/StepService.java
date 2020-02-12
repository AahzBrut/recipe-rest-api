package ru.aahzbrut.reciperestapi.services;

import ru.aahzbrut.reciperestapi.dto.requests.StepRequest;
import ru.aahzbrut.reciperestapi.dto.responses.step.StepResponse;

import java.util.List;

public interface StepService {

    StepResponse getById(Long stepId);

    void deleteById(Long stepId);

    List<StepResponse> getAllSteps();

    StepResponse addNew(StepRequest stepRequest);

    StepResponse update(Long stepId, StepRequest stepRequest);
}
