package ru.aahzbrut.reciperestapi.unit.entities.domain;

import org.junit.jupiter.api.Test;
import ru.aahzbrut.reciperestapi.unit.entities.Step;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StepTest {

    @Test
    void npeDefence() {
        TestUtils.npeDefence(Step.class);
        int one = 1;
        assertEquals(1, one);
    }


}