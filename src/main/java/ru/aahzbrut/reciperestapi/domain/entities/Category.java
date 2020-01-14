package ru.aahzbrut.reciperestapi.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import ru.aahzbrut.reciperestapi.domain.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@GenericGenerator(
        name = "default_gen",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {@Parameter(name="sequence_name", value = "CATEGORY_SEQ")})
@AttributeOverride(name = "id", column = @Column(name = "CATEGORY_ID"))
@Table(name = "CATEGORY")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "NAME")
    @ToString.Include
    private String name;

    @Column(name = "DESCRIPTION")
    @ToString.Include
    private String description;

    @ManyToMany(mappedBy = "categories")
    private List<Recipe> recipes = new LinkedList<>();
}
