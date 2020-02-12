package ru.aahzbrut.reciperestapi.dto.responses.step;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static ru.aahzbrut.reciperestapi.utils.Constants.ISO_DATE_TIME_PATTERN;

@Getter
@Setter
@NoArgsConstructor
public class StepResponse {

    private Long id;

    private String name;

    private String description;

    private Integer preparationTime;

    private Integer cookingTime;

    private List<StepIngredientResponse> ingredients = new LinkedList<>();

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    private LocalDateTime createdDateTime;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    private LocalDateTime updatedDateTime;
}
