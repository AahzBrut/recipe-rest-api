package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.Note;
import ru.aahzbrut.reciperestapi.dto.responses.note.NoteResponse;

public interface NoteResponseMapper {

    NoteResponse from(Note note);
}
