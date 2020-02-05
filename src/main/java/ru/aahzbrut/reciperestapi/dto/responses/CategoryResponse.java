package ru.aahzbrut.reciperestapi.dto.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import static ru.aahzbrut.reciperestapi.utils.Constants.ISO_DATE_TIME_PATTERN;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class CategoryResponse {

    private Long id;

    private String name;

    private String description;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    private LocalDateTime createdDateTime;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    private LocalDateTime updatedDateTime;
}
