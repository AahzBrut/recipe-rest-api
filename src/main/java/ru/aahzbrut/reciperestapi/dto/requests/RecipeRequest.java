package ru.aahzbrut.reciperestapi.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.aahzbrut.reciperestapi.domain.Difficulty;

@Getter
@Setter
@NoArgsConstructor
public class RecipeRequest {

    private String name;

    private String description;

    private Difficulty difficulty;

    private Integer numServings;

    private String source;

    private String url;

    private byte[] image;
}
