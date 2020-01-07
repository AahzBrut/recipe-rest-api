package ru.aahzbrut.reciperestapi.dto.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class CategoryResponse {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
}
