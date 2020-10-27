package ru.aahzbrut.reciperestapi.domain.entities;

import lombok.*;
import lombok.experimental.Accessors;
import ru.aahzbrut.reciperestapi.domain.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Entity(name = "INGREDIENT")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "INGREDIENT_ID"))
public class Ingredient extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
    private List<StepIngredient> stepIngredients = Collections.emptyList();

    @Override
    public Ingredient setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Ingredient setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
    }

    @Override
    public Ingredient setModifiedDateTime(LocalDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
        return this;
    }
}
