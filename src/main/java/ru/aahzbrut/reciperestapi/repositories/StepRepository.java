package ru.aahzbrut.reciperestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aahzbrut.reciperestapi.domain.entities.Step;

@Repository
public interface StepRepository extends JpaRepository<Step, Long> {
}
