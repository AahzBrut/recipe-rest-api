package ru.aahzbrut.reciperestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aahzbrut.reciperestapi.unit.entities.StepIngredient;

@Repository
public interface StepIngredientRepository extends JpaRepository<StepIngredient, Long> {
}
