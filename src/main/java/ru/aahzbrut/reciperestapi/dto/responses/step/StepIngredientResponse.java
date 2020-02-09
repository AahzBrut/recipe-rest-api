package ru.aahzbrut.reciperestapi.dto.responses.step;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.aahzbrut.reciperestapi.dto.responses.ingredient.IngredientResponse;
import ru.aahzbrut.reciperestapi.dto.responses.uom.UOMResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static ru.aahzbrut.reciperestapi.utils.Constants.ISO_DATE_TIME_PATTERN;


@Getter
@Setter
@NoArgsConstructor
public class StepIngredientResponse {

    private Long id;

    private IngredientResponse ingredient;

    private UOMResponse uom;

    private BigDecimal uomCount;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    private LocalDateTime createdDateTime;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    private LocalDateTime updatedDateTime;
}
