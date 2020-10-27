package ru.aahzbrut.reciperestapi.mappers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Step;
import ru.aahzbrut.reciperestapi.dto.responses.step.StepResponse;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StepResponseMapper implements Mapper<StepResponse, Step> {

    private final StepIngredientResponseMapper stepIngredientResponseMapper;

    @Override
    public StepResponse from(Step step) {
        StepResponse stepResponse = new StepResponse();
        stepResponse.setId(step.getId());
        stepResponse.setName(step.getName());
        stepResponse.setDescription(step.getDescription());
        stepResponse.setPreparationTime(step.getPreparationTime());
        stepResponse.setCookingTime(step.getCookingTime());
        stepResponse.setIngredients(stepIngredientResponseMapper.from(step.getStepIngredients()));
        stepResponse.setCreatedDateTime(step.getCreatedDateTime());
        stepResponse.setUpdatedDateTime(step.getModifiedDateTime());

        return null;
    }
}
