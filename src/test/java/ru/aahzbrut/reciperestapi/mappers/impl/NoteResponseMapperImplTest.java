package ru.aahzbrut.reciperestapi.mappers.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aahzbrut.reciperestapi.domain.entities.Note;
import ru.aahzbrut.reciperestapi.domain.entities.Recipe;
import ru.aahzbrut.reciperestapi.dto.requests.NoteRequest;
import ru.aahzbrut.reciperestapi.dto.responses.NoteResponse;
import ru.aahzbrut.reciperestapi.mappers.NoteResponseMapper;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class NoteResponseMapperImplTest {


    private static final Long RECIPE_ID = 112L;
    private static final String RECIPE_NAME = "Wonderful recipe";
    private static final String RECIPE_DESCRIPTION = "Very simple but tasty recipe";
    private static final Long NOTE_ID = 1L;
    private static final String NOTE_TEXT = "notes about recipe";
    private static final LocalDateTime CREATED_DATE_TIME = LocalDateTime.now();
    private static final LocalDateTime MODIFIED_DATE_TIME = LocalDateTime.now().plusMinutes(1);

    Note note;

    NoteResponse noteResponse;

    NoteRequest noteRequest;

    NoteResponseMapper noteResponseMapper = new NoteResponseMapperImpl();

    @BeforeEach
    void setUp() {
        note = initNote();
        noteResponse = initNoteResponse();
        noteRequest = initNoteRequest();
    }

    private NoteRequest initNoteRequest() {

        NoteRequest result = new NoteRequest();
        result.setRecipeId(RECIPE_ID);
        result.setNoteText(NOTE_TEXT);

        return result;
    }

    private NoteResponse initNoteResponse() {

        NoteResponse result = new NoteResponse();
        result.setId(NOTE_ID);
        result.setRecipeId(RECIPE_ID);
        result.setNoteText(NOTE_TEXT);
        result.setCreatedDateTime(CREATED_DATE_TIME);
        result.setModifiedDateTime(MODIFIED_DATE_TIME);

        return result;
    }

    private Note initNote() {
        Recipe recipe = new Recipe();
        recipe.setId(RECIPE_ID);
        recipe.setName(RECIPE_NAME);
        recipe.setDescription(RECIPE_DESCRIPTION);

        Note result = new Note();
        result.setId(NOTE_ID);
        result.setRecipe(recipe);
        result.setNoteText(NOTE_TEXT);
        result.setCreatedDateTime(CREATED_DATE_TIME);
        result.setModifiedDateTime(MODIFIED_DATE_TIME);
        recipe.getNotes().add(result);

        return result;
    }

    @Test
    void from() {
        NoteResponse testNoteResponse = noteResponseMapper.from(note);

        assertThat(testNoteResponse.getId()).isEqualTo(NOTE_ID);
        assertThat(testNoteResponse.getRecipeId()).isEqualTo(RECIPE_ID);
        assertThat(testNoteResponse.getNoteText()).isEqualTo(NOTE_TEXT);
        assertThat(testNoteResponse.getCreatedDateTime()).isEqualTo(CREATED_DATE_TIME);
        assertThat(testNoteResponse.getModifiedDateTime()).isEqualTo(MODIFIED_DATE_TIME);
    }
}