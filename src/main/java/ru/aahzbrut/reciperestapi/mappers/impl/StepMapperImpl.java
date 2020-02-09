package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Step;
import ru.aahzbrut.reciperestapi.dto.requests.StepRequest;
import ru.aahzbrut.reciperestapi.mappers.StepMapper;

@Service
public class StepMapperImpl implements StepMapper {

    @Override
    public Step from(StepRequest stepRequest) {
        Step step = new Step();
        step.setName(stepRequest.getName());
        step.setDescription(stepRequest.getDescription());
        step.setPreparationTime(stepRequest.getPreparationTime());
        step.setCookingTime(stepRequest.getCookingTime());

        return step;
    }

    @Override
    public Step merge(Step step, StepRequest stepRequest) {
        step.setName(stepRequest.getName());
        step.setDescription(stepRequest.getDescription());
        step.setPreparationTime(stepRequest.getPreparationTime());
        step.setCookingTime(stepRequest.getCookingTime());

        return step;
    }
}
