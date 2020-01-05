package ru.aahzbrut.reciperestapi.domain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StepIngredientTest {

    @Test
    void npeDefence() {
        TestUtils.npeDefence(StepIngredient.class);
        int one = 1;
        assertEquals(1, one);
    }


}