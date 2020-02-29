package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Note;
import ru.aahzbrut.reciperestapi.dto.responses.note.NoteResponse;
import ru.aahzbrut.reciperestapi.mappers.NoteResponseMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteResponseMapperImpl implements NoteResponseMapper {

    @Override
    public NoteResponse from(Note note) {
        NoteResponse result = new NoteResponse();
        result.setId(note.getId());
        result.setRecipeId(note.getRecipe().getId());
        result.setNoteText(note.getNoteText());
        result.setCreatedDateTime(note.getCreatedDateTime());
        result.setUpdatedDateTime(note.getModifiedDateTime());

        return result;
    }

    @Override
    public List<NoteResponse> from(List<Note> notes) {
        return notes
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
}
