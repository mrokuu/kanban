package org.example.entities.task;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.project.Project;
import org.example.entities.user.User;
import org.example.enums.progress.Progress;
import org.example.id.TaskId;
import org.example.valueobjects.Description;
import org.example.valueobjects.Name;
import org.example.valueobjects.Priority;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tasks")
public class Task {

//    @EmbeddedId
//    private TaskId id;
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
            @AttributeOverride(name = "value", column = @Column(name = "priority", nullable = false))
    })
    private Priority priority;

    private Progress progress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "tasks_users",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();




}
