package ru.aahzbrut.reciperestapi.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.aahzbrut.reciperestapi.domain.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(name = "default_gen", sequenceName = "UOM_SEQ", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "UOM_ID"))
@Table(name = "UOM")
@SuperBuilder
public class UOM extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
}
