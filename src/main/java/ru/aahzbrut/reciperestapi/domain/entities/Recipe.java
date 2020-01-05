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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(name = "default_gen", sequenceName = "RECIPE_SEQ", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "RECIPE_ID"))
@Table(name = "RECIPE")
@SuperBuilder
public class Recipe extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DIFFICULTY")
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column(name = "SERVINGS")
    private Integer numServings;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "URL")
    private String url;

    @Lob
    @Column(name = "IMAGE")
    @Builder.Default
    private byte[] image = new byte[0];

    @ManyToMany
    @JoinTable(name = "RECIPE_CATEGORY",
            joinColumns = {@JoinColumn(name = "RECIPE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID")})
    @Builder.Default()
    private List<Category> categories = new LinkedList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    @Builder.Default()
    private List<Note> notes = new LinkedList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    @Builder.Default()
    private List<RecipeStep> recipeSteps = new LinkedList<>();
}
