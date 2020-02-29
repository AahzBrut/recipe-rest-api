package ru.aahzbrut.reciperestapi.dto.responses.recipe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RecipeResponseList {

    private List<RecipeResponse> steps = new LinkedList<>();
}
