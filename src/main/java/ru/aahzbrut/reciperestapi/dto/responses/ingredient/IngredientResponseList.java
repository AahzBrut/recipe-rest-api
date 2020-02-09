package ru.aahzbrut.reciperestapi.dto.responses.ingredient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientResponseList {
    private List<IngredientResponse> ingredients = new LinkedList<>();
}
