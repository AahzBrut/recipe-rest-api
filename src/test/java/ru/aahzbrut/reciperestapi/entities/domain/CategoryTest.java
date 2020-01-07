package ru.aahzbrut.reciperestapi.entities.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ru.aahzbrut.reciperestapi.domain.entities.Category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Slf4j
class CategoryTest {

    private static final Long firstId = 1L;
    private static final Long secondId = 2L;

    @Test
    void npeDefence() {
        TestUtils.npeDefence(Category.class);
        int one = 1;
        assertEquals(1, one);
    }

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

        category1 = Category.builder().id(firstId).name("First recipe").build();
        category2 = Category.builder().id(firstId).name("Second recipe").build();

        assertEquals(category1, category2);
    }
}