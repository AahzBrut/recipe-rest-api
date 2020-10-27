package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Step;
import ru.aahzbrut.reciperestapi.dto.requests.StepRequest;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

@Service
public class StepMapper implements Mapper<Step, StepRequest> {

    @Override
    public Step from(StepRequest source) {

        return new Step()
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setPreparationTime(source.getPreparationTime())
                .setCookingTime(source.getCookingTime());
    }
}