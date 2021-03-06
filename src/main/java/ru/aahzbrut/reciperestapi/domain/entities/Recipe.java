package ru.aahzbrut.reciperestapi.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.aahzbrut.reciperestapi.domain.BaseEntity;
import ru.aahzbrut.reciperestapi.domain.Difficulty;

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
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "RECIPE")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "RECIPE_ID"))
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
    private byte[] image = new byte[0];

    @ManyToMany
    @JoinTable(name = "RECIPE_CATEGORY",
            joinColumns = {@JoinColumn(name = "RECIPE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID")})
    private List<Category> categories = new LinkedList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<Note> notes = new LinkedList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<RecipeStep> recipeSteps = new LinkedList<>();

    public Recipe(Long recipeId) {
        this.setId(recipeId);
    }

    @Override
    public Recipe setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Recipe setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
    }

    @Override
    public Recipe setModifiedDateTime(LocalDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
        return this;
    }

}
