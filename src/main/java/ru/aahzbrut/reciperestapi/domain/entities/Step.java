package ru.aahzbrut.reciperestapi.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.aahzbrut.reciperestapi.domain.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "STEP")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "STEP_ID"))
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
    private List<RecipeStep> recipeSteps = new LinkedList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "step")
    private List<StepIngredient> stepIngredients = new LinkedList<>();

    @Override
    public Step setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Step setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
    }

    @Override
    public Step setModifiedDateTime(LocalDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
        return this;
    }
}
