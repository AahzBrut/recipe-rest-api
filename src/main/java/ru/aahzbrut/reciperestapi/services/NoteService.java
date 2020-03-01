package ru.aahzbrut.reciperestapi.services;

import ru.aahzbrut.reciperestapi.dto.requests.NoteRequest;
import ru.aahzbrut.reciperestapi.dto.responses.note.NoteResponse;

import java.util.List;

public interface NoteService {

    NoteResponse getNoteById(Long noteId);
    List<NoteResponse> getAllNotes();
    NoteResponse createNote(NoteRequest noteRequest);
    NoteResponse updateNote(long noteId, NoteRequest noteRequest);
    void deleteById(Long noteId);
}
