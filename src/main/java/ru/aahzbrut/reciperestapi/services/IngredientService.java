package ru.aahzbrut.reciperestapi.services;

import ru.aahzbrut.reciperestapi.dto.requests.IngredientRequest;
import ru.aahzbrut.reciperestapi.dto.responses.ingredient.IngredientResponse;

import java.util.List;

public interface IngredientService {

    IngredientResponse getById(Long ingredientId);

    void deleteById(Long ingredientId);

    List<IngredientResponse> getAllCategories();

    IngredientResponse update(Long ingredientId, IngredientRequest ingredientRequest);

    IngredientResponse create(IngredientRequest ingredientRequest);
}
