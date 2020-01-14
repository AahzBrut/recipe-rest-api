package ru.aahzbrut.reciperestapi.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

import static org.hibernate.id.enhanced.SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @GenericGenerator(
            name = "sequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = CONFIG_PREFER_SEQUENCE_PER_ENTITY, value = "true"),
                    @Parameter(name = CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, value = "_SEQ")
            })
    @EqualsAndHashCode.Include
    private Long id;

    @CreationTimestamp
    @Column(name = "CREATED_TIMESTAMP")
    protected LocalDateTime createdDateTime;

    @UpdateTimestamp
    @Column(name = "MODIFIED_TIMESTAMP")
    protected LocalDateTime updatedDateTime;
}
