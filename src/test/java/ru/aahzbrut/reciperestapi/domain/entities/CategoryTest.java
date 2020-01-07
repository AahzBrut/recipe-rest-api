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

        Category category1 = Category.builder().id(firstId).build();
        Category category2 = Category.builder().id(secondId).build();

        assertNotEquals(category1, category2);

        category1 = Category.builder().id(null).build();
        category2 = Category.builder().id(secondId).build();

        assertNotEquals(category1, category2);

        category1 = Category.builder().id(firstId).build();
        category2 = Category.builder().id(null).build();

        assertNotEquals(category1, category2);

        category1 = Category.builder().id(firstId).build();
        category2 = Category.builder().id(firstId).build();

        assertEquals(category1, category2);

        category1 = Category.builder().id(firstId).name(firstName).build();
        category2 = Category.builder().id(firstId).name(secondName).build();

        assertEquals(category1, category2);
    }
}