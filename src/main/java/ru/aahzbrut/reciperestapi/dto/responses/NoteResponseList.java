package ru.aahzbrut.reciperestapi.dto.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NoteResponseList {

    private List<NoteResponse> notes = new LinkedList<>();
}
