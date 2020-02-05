package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Note;
import ru.aahzbrut.reciperestapi.domain.entities.Recipe;
import ru.aahzbrut.reciperestapi.dto.requests.NoteRequest;
import ru.aahzbrut.reciperestapi.mappers.NoteMapper;

@Service
public class NoteMapperImpl implements NoteMapper {

    @Override
    public Note from(NoteRequest noteRequest) {
        Note note = new Note();
        note.setNoteText(noteRequest.getNoteText());
        note.setRecipe(new Recipe(noteRequest.getRecipeId()));

        return note;
    }
}
