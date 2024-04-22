package org.example.commands.user;

import org.example.commands.project.UpdateProjectCommandHandler;
import org.example.entities.project.Project;
import org.example.entities.task.Task;
import org.example.dispacher.Handler;
import org.example.dispacher.Request;
import org.example.valueobjects.Email;
import org.example.valueobjects.Name;
import org.example.valueobjects.Password;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
@Handler(handler = UpdateProjectCommandHandler.class)
public record UpdateUserCommand(
        UUID id,
        Email email,
        Name name,
        Password password,
        LocalDate registrationDate,
        Set<Project> projects,
        Set<Task> tasks
) implements Request {
}
