package ru.aahzbrut.reciperestapi.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class IngredientRequest {
    private String name;
    private String description;
}
