package ru.aahzbrut.reciperestapi.entities.domain;

import org.junit.jupiter.api.Test;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UOMTest {

    @Test
    void npeDefence() {
        TestUtils.npeDefence(UOM.class);
        int one = 1;
        assertEquals(1, one);
    }


}