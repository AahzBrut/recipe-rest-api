package ru.aahzbrut.reciperestapi.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Ingredient;
import ru.aahzbrut.reciperestapi.dto.requests.IngredientRequest;
import ru.aahzbrut.reciperestapi.dto.responses.ingredient.IngredientResponse;
import ru.aahzbrut.reciperestapi.mappers.IngredientMapper;
import ru.aahzbrut.reciperestapi.mappers.IngredientResponseMapper;
import ru.aahzbrut.reciperestapi.repositories.IngredientRepository;
import ru.aahzbrut.reciperestapi.services.IngredientService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static ru.aahzbrut.reciperestapi.utils.DebugStrings.FINISH;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.START;
import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@RequiredArgsConstructor
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientResponseMapper ingredientResponseMapper;
    private final IngredientMapper ingredientMapper;

    @Override
    @Transactional
    public IngredientResponse getById(Long ingredientId) {
        log.debug(START + getCurrentMethodName());

        Ingredient ingredient = ingredientRepository.getOne(ingredientId);
        log.trace("Ingredient with ID:" + ingredientId + " - " + ingredient);

        IngredientResponse response = ingredientResponseMapper.from(ingredient);
        log.trace("IngredientResponse with ID:" + ingredientId + " - " + response);

        log.debug(FINISH + getCurrentMethodName());
        return response;
    }

    @Override
    public void deleteById(Long ingredientId) {
        log.debug(START + getCurrentMethodName());

        ingredientRepository.deleteById(ingredientId);

        log.debug(FINISH + getCurrentMethodName());
    }

    @Override
    public List<IngredientResponse> getAllCategories() {
        log.debug(START + getCurrentMethodName());

        List<IngredientResponse> ingredients = ingredientRepository.findAll().stream()
                .map(ingredientResponseMapper::from)
                .collect(Collectors.toList());
        log.trace("Ingredients: " + ingredients);

        log.debug(FINISH + getCurrentMethodName());
        return ingredients;
    }

    @Transactional
    @Override
    public IngredientResponse update(Long ingredientId, IngredientRequest ingredientRequest) {
        log.debug(START + getCurrentMethodName());

        Ingredient ingredient = ingredientRepository.getOne(ingredientId);
        log.trace("Ingredient before update: " + ingredient.toString());

        ingredient = ingredientMapper.merge(ingredient, ingredientRequest);
        log.trace("Ingredient after update: " + ingredient.toString());

        ingredient = ingredientRepository.saveAndFlush(ingredient);
        log.trace("Ingredient after save: " + ingredient.toString());

        log.debug(FINISH + getCurrentMethodName());
        return ingredientResponseMapper.from(ingredient);
    }

    @Override
    public IngredientResponse create(IngredientRequest ingredientRequest) {
        log.debug(START + getCurrentMethodName());

        Ingredient ingredient = ingredientMapper.from(ingredientRequest);
        log.trace("Ingredient before save: " + ingredient.toString());

        ingredient = ingredientRepository.saveAndFlush(ingredient);
        log.trace("Ingredient after save: " + ingredient.toString());

        log.debug(FINISH + getCurrentMethodName());
        return ingredientResponseMapper.from(ingredient);
    }
}
