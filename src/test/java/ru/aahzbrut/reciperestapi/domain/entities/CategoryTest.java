package ru.aahzbrut.reciperestapi.domain.entities;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Slf4j
class CategoryTest extends BaseTestEntity {

    private static final Long firstId = 1L;
    private static final Long secondId = 2L;
    private static final String firstName = "First recipe";
    private static final String secondName = "Second recipe";

    @Test
    void equalsTest() {

        Category category1 = new Category();
        category1.setId(firstId);
        Category category2 = new Category();
        category2.setId(secondId);

        assertNotEquals(category1, category2);

        category1 = new Category();
        category1.setId(null);
        category2 = new Category();
        category2.setId(secondId);

        assertNotEquals(category1, category2);

        category1 = new Category();
        category1.setId(firstId);
        category2 = new Category();
        category2.setId(null);

        assertNotEquals(category1, category2);

        category1 = new Category();
        category1.setId(firstId);
        category2 = new Category();
        category2.setId(firstId);

        assertEquals(category1, category2);

        category1 = new Category();
        category1.setId(firstId);
        category1.setName(firstName);
        category2 = new Category();
        category2.setId(firstId);
        category2.setName(secondName);

        assertEquals(category1, category2);
    }
}