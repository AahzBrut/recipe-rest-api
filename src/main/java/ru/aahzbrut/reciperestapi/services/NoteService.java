package ru.aahzbrut.reciperestapi.services;

import ru.aahzbrut.reciperestapi.dto.requests.NoteRequest;
import ru.aahzbrut.reciperestapi.dto.responses.NoteResponse;

import java.util.List;

public interface NoteService {

    NoteResponse getNoteById(Long noteId);
    List<NoteResponse> getAllNotes();
    NoteResponse updateNote(NoteRequest noteRequest);
    void deleteById(Long noteId);
}
