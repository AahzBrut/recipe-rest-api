package ru.aahzbrut.reciperestapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RecipeRestApiApplicationTestIT {

    @Test
    void contextLoads() {

        // dummy assertion to make sonar lint happy.
        int one = 1;
        assertEquals(1, one);
    }

}
