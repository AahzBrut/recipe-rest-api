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
@SequenceGenerator(name = "default_gen", sequenceName = "STEP_SEQ", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "STEP_ID"))
@Table(name = "STEP")
@SuperBuilder
public class Step extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PREPARATION_TIME")
    private Integer preparationTime;

    @Column(name = "COOKING_TIME")
    private Integer cookingTime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "step")
    @Builder.Default()
    private List<RecipeStep> recipeSteps = new LinkedList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "step")
    @Builder.Default()
    private List<StepIngredient> stepIngredients = new LinkedList<>();
}
