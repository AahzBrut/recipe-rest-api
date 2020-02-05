package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.Note;
import ru.aahzbrut.reciperestapi.dto.requests.NoteRequest;

public interface NoteMapper {

    Note from(NoteRequest noteRequest);
}
