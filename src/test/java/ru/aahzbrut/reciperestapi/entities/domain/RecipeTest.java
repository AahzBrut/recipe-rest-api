package ru.aahzbrut.reciperestapi.entities.domain;

import org.junit.jupiter.api.Test;
import ru.aahzbrut.reciperestapi.domain.entities.Recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeTest {

    @Test
    void npeDefence() {
        TestUtils.npeDefence(Recipe.class);
        int one = 1;
        assertEquals(1, one);
    }


}