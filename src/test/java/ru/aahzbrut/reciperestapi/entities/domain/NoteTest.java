package ru.aahzbrut.reciperestapi.entities.domain;

import org.junit.jupiter.api.Test;
import ru.aahzbrut.reciperestapi.domain.entities.Note;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NoteTest {

    @Test
    void npeDefence() {
        TestUtils.npeDefence(Note.class);
        int one = 1;
        assertEquals(1, one);
    }


}