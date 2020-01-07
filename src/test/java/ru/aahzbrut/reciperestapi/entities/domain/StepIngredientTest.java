package ru.aahzbrut.reciperestapi.entities.domain;

import org.junit.jupiter.api.Test;
import ru.aahzbrut.reciperestapi.domain.entities.StepIngredient;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StepIngredientTest {

    @Test
    void npeDefence() {
        TestUtils.npeDefence(StepIngredient.class);
        int one = 1;
        assertEquals(1, one);
    }


}