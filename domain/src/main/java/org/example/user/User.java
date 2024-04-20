package org.example.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.id.UserId;
import org.example.project.Project;
import org.example.task.Task;
import org.example.valueobjects.Name;
import org.example.valueobjects.Password;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = {"projects", "tasks"})
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@JsonIgnoreProperties({"projects", "tasks"})
public class User {

    @EmbeddedId
    private UserId id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "email", nullable = false))
    })
    private Email email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "name", nullable = false))
    })
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "password", nullable = false))
    })
    private Password password;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;

    @ManyToMany(mappedBy = "users")
    private Set<Project> projects = new HashSet<>();

    @ManyToMany(mappedBy = "users")
    private Set<Task> tasks = new HashSet<>();


}
