package org.example.entities.project;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.user.User;
import org.example.id.ProjectId;
import org.example.valueobjects.Description;
import org.example.valueobjects.Name;
import org.example.valueobjects.NumberWip;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "projects")
@Builder
public class Project
{
//    @EmbeddedId
//    private ProjectId id;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "name", nullable = false))
    })
    private Name name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "description", nullable = false))
    })
    private Description description;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "numberWip", nullable = false))
    })
    private NumberWip numberWip;

    @OneToOne(cascade = CascadeType.ALL)
    private User leaderUser;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "projects_users",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();



}
