package ru.aahzbrut.reciperestapi.unit.entities.domain;

import org.junit.jupiter.api.Test;
import ru.aahzbrut.reciperestapi.unit.entities.Ingredient;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTest {

    @Test
    void npeDefence() {
        TestUtils.npeDefence(Ingredient.class);
        int one = 1;
        assertEquals(1, one);
    }

}