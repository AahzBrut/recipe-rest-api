package ru.aahzbrut.reciperestapi.services;

import ru.aahzbrut.reciperestapi.dto.requests.IngredientRequest;
import ru.aahzbrut.reciperestapi.dto.responses.IngredientResponse;

import java.util.List;

public interface IngredientService {

    IngredientResponse getById(Long ingredientId);

    void deleteById(Long ingredientId);

    List<IngredientResponse> getAllCategories();

    IngredientResponse update(IngredientRequest ingredientRequest);
}
