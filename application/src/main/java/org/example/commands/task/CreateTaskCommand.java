package org.example.commands.task;

import org.example.commands.project.CreateProjectCommandHandler;
import org.example.entities.project.Project;
import org.example.entities.user.User;
import org.example.enums.progress.Progress;
import org.example.mediator.Handler;
import org.example.mediator.Request;
import org.example.valueobjects.Description;
import org.example.valueobjects.Name;
import org.example.valueobjects.Priority;

import java.util.Set;
import java.util.UUID;
@Handler(handler = CreateTaskCommandHandler.class)
public record CreateTaskCommand(
        UUID id,
        Name name,
        Description description,
        Priority priority,
        Progress progress,
        Project project,
        Set<User> users
) implements Request {
}
