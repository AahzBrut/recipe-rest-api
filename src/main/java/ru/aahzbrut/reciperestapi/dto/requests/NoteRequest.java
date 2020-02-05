package ru.aahzbrut.reciperestapi.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoteRequest {

    private Long recipeId;
    private String noteText;
}
