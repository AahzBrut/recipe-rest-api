package ru.aahzbrut.reciperestapi.mappers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.StepIngredient;
import ru.aahzbrut.reciperestapi.dto.responses.step.StepIngredientResponse;
import ru.aahzbrut.reciperestapi.mappers.IngredientResponseMapper;
import ru.aahzbrut.reciperestapi.mappers.StepIngredientResponseMapper;
import ru.aahzbrut.reciperestapi.mappers.UOMResponseMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StepIngredientResponseMapperImpl implements StepIngredientResponseMapper {

    private final IngredientResponseMapper ingredientResponseMapper;
    private final UOMResponseMapper uomResponseMapper;

    @Override
    public StepIngredientResponse from(StepIngredient stepIngredient) {
        StepIngredientResponse result = new StepIngredientResponse();
        result.setId(stepIngredient.getId());
        result.setIngredient(ingredientResponseMapper.from(stepIngredient.getIngredient()));
        result.setUom(uomResponseMapper.from(stepIngredient.getUom()));
        result.setUomCount(stepIngredient.getUomAmount());
        result.setCreatedDateTime(stepIngredient.getCreatedDateTime());
        result.setUpdatedDateTime(stepIngredient.getModifiedDateTime());

        return null;
    }

    @Override
    public List<StepIngredientResponse> from(List<StepIngredient> stepIngredients) {
        return stepIngredients
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
}
