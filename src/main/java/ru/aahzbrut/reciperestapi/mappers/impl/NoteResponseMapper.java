package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Note;
import ru.aahzbrut.reciperestapi.dto.responses.note.NoteResponse;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

@Service
public class NoteResponseMapper implements Mapper<NoteResponse, Note> {

    @Override
    public NoteResponse from(Note source) {

        return new NoteResponse()
                .setId(source.getId())
                .setRecipeId(source.getRecipe().getId())
                .setNoteText(source.getNoteText())
                .setCreatedDateTime(source.getCreatedDateTime())
                .setUpdatedDateTime(source.getModifiedDateTime());
    }
}
