package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Step;
import ru.aahzbrut.reciperestapi.dto.requests.StepRequest;
import ru.aahzbrut.reciperestapi.mappers.Merger;

@Service
public class StepMerger implements Merger<Step, StepRequest> {

    @Override
    public Step merge(Step source1, StepRequest source2) {

        return source1
                .setName(source2.getName())
                .setDescription(source2.getDescription())
                .setCookingTime(source2.getCookingTime())
                .setPreparationTime(source2.getPreparationTime());
    }
}
