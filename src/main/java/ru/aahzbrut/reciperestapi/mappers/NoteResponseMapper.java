package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.Note;
import ru.aahzbrut.reciperestapi.dto.responses.note.NoteResponse;

import java.util.List;

public interface NoteResponseMapper {

    NoteResponse from(Note note);

    List<NoteResponse> from(List<Note> notes);
}
