package ru.aahzbrut.reciperestapi.dto.responses.note;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import static ru.aahzbrut.reciperestapi.utils.Constants.ISO_DATE_TIME_PATTERN;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class NoteResponse {

    private Long id;

    private Long recipeId;

    private String noteText;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    private LocalDateTime createdDateTime;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    private LocalDateTime updatedDateTime;
}
