package ru.aahzbrut.reciperestapi.dto.responses.uom;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import static ru.aahzbrut.reciperestapi.utils.Constants.ISO_DATE_TIME_PATTERN;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class UOMResponse {

    private Long id;

    private String name;

    private String description;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    private LocalDateTime createdDateTime;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    private LocalDateTime updatedDateTime;
}
