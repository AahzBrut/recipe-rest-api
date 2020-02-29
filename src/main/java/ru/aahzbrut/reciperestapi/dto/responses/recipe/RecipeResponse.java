package ru.aahzbrut.reciperestapi.dto.responses.recipe;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.aahzbrut.reciperestapi.domain.Difficulty;
import ru.aahzbrut.reciperestapi.dto.responses.category.CategoryResponse;
import ru.aahzbrut.reciperestapi.dto.responses.note.NoteResponse;
import ru.aahzbrut.reciperestapi.dto.responses.step.StepResponse;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static ru.aahzbrut.reciperestapi.utils.Constants.ISO_DATE_TIME_PATTERN;

@Getter
@Setter
@NoArgsConstructor
public class RecipeResponse {

    private Long id;

    private String name;

    private String description;

    private Difficulty difficulty;

    private Integer numServings;

    private String source;

    private String url;

    private byte[] image;

    private List<CategoryResponse> categories = new LinkedList<>();

    private List<NoteResponse> notes = new LinkedList<>();

    private List<StepResponse> steps = new LinkedList<>();

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    private LocalDateTime createdDateTime;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    private LocalDateTime updatedDateTime;
}
