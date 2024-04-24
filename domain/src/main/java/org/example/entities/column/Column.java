package org.example.entities.column;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.project.Project;
import org.example.valueobjects.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "columns")
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "name", nullable = false))
    })
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "description", nullable = false))
    })
    private Description description;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "wip", nullable = false))
    })
    private Wip wip;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "isWip", nullable = false))
    })
    private IsWip isWip;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "numberOrder", nullable = false))
    })
    private NumberOrder numberOrder;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

}
