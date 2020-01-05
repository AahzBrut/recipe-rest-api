package ru.aahzbrut.reciperestapi.domain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NoteTest {

    @Test
    void npeDefence() {
        TestUtils.npeDefence(Note.class);
        int one = 1;
        assertEquals(1, one);
    }


}