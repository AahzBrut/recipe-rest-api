package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Note;
import ru.aahzbrut.reciperestapi.domain.entities.Recipe;
import ru.aahzbrut.reciperestapi.dto.requests.NoteRequest;
import ru.aahzbrut.reciperestapi.mappers.Merger;

@Service
public class NoteMerger implements Merger<Note, NoteRequest> {

    @Override
    public Note merge(Note source1, NoteRequest source2) {

        return source1
                .setNoteText(source2.getNoteText())
                .setRecipe(new Recipe(source2.getRecipeId()));
    }
}
