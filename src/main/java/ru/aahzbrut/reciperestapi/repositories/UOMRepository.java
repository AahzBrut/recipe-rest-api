package ru.aahzbrut.reciperestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;

@Repository
public interface UOMRepository extends JpaRepository<UOM, Long> {
    UOM getFirstByName(String uomName);
}
