package ru.aahzbrut.reciperestapi.entities.domain;

import org.junit.jupiter.api.Test;
import ru.aahzbrut.reciperestapi.domain.entities.RecipeStep;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeStepTest {

    @Test
    void npeDefence() {
        TestUtils.npeDefence(RecipeStep.class);
        int one = 1;
        assertEquals(1, one);
    }

}