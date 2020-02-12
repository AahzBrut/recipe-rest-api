package ru.aahzbrut.reciperestapi.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StepRequest {

    private String name;

    private String description;

    private Integer preparationTime;

    private Integer cookingTime;
}
