package ru.aahzbrut.reciperestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aahzbrut.reciperestapi.unit.entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
