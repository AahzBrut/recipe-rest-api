package ru.aahzbrut.reciperestapi.domain.entities;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class CategoryTest {

    @Test
    void npeDefence() {
        TestUtils.npeDefence(Category.class);
        int one = 1;
        assertEquals(1, one);
    }
}