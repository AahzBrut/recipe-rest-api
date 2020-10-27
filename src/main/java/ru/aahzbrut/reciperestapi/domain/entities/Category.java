package ru.aahzbrut.reciperestapi.domain.entities;

import lombok.*;
import lombok.experimental.Accessors;
import ru.aahzbrut.reciperestapi.domain.BaseEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "CATEGORY")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "CATEGORY_ID"))
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

    @Override
    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Category setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
    }

    @Override
    public Category setModifiedDateTime(LocalDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
        return this;
    }
}
