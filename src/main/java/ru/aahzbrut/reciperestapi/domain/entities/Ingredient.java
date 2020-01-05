package ru.aahzbrut.reciperestapi.domain.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.aahzbrut.reciperestapi.domain.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(name = "default_gen", sequenceName = "INGREDIENT_SEQ", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "INGREDIENT_ID"))
@Table(name = "INGREDIENT")
@SuperBuilder
public class Ingredient extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
    @Builder.Default
    private List<StepIngredient> stepIngredients = new LinkedList<>();
}
