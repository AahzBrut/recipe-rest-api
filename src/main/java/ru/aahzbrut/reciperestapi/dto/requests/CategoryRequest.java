package ru.aahzbrut.reciperestapi.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryRequest {

    private String name;
    private String description;
}
