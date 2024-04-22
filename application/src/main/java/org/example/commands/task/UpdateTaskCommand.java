package org.example.commands.task;

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
@Handler(handler = UpdateTaskCommandHandler.class)
public record UpdateTaskCommand(
                                UUID id,
                                Name name,
                                Description description,
                                Priority priority,
                                Progress progress,
                                Project project,
                                Set<User> users
) implements Request {
}
