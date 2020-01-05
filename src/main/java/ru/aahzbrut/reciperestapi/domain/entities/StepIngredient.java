package ru.aahzbrut.reciperestapi.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.aahzbrut.reciperestapi.domain.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(name = "default_gen", sequenceName = "STEP_INGREDIENT_SEQ", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "STEP_INGREDIENT_ID"))
@Table(name = "STEP_INGREDIENT")
@SuperBuilder
public class StepIngredient extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STEP_ID")
    private Step step;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UOM_ID")
    private UOM uom;

    @Column(name = "UOM_AMOUNT")
    private BigDecimal uomAmount;
}
