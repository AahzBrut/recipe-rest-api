package ru.aahzbrut.reciperestapi.unit.entities.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ru.aahzbrut.reciperestapi.unit.entities.Category;

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