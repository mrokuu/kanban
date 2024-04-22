package org.example.dtos;

import lombok.Builder;
import org.example.entities.project.Project;
import org.example.entities.task.Task;
import org.example.valueobjects.Email;
import org.example.valueobjects.Name;
import org.example.valueobjects.Password;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Builder
public record UserDto(
        UUID id,
        Email email,
        Name name,
        Password password,
        LocalDate registrationDate,
        Set<Project> projects,
        Set<Task> tasks
) {
}
