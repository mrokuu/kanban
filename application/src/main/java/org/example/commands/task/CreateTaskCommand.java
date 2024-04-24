package org.example.commands.task;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.entities.project.Project;
import org.example.entities.user.User;
import org.example.enums.progress.Progress;
import org.example.dispacher.Handler;
import org.example.dispacher.Request;
import org.example.valueobjects.Description;
import org.example.valueobjects.Name;
import org.example.valueobjects.Priority;

import java.util.Set;
import java.util.UUID;
@Handler(handler = CreateTaskCommandHandler.class)
public record CreateTaskCommand(
        UUID id,
        @NotNull @Size(min = 2) Name name,
        Description description,
        @Min(0) @Max(3) Priority priority,
        Progress progress,
        Project project,
        Set<User> users
) implements Request {
}
