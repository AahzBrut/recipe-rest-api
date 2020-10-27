package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Note;
import ru.aahzbrut.reciperestapi.domain.entities.Recipe;
import ru.aahzbrut.reciperestapi.dto.requests.NoteRequest;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

@Service
public class NoteMapper implements Mapper<Note, NoteRequest> {

    @Override
    public Note from(NoteRequest source) {

        return new Note()
                .setNoteText(source.getNoteText())
                .setRecipe(new Recipe(source.getRecipeId()));
    }
}
