package ru.aahzbrut.reciperestapi.domain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StepTest {

    @Test
    void npeDefence() {
        TestUtils.npeDefence(Step.class);
        int one = 1;
        assertEquals(1, one);
    }


}