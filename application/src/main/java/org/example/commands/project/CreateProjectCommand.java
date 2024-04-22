package org.example.commands.project;

import org.example.dispacher.Handler;
import org.example.dispacher.Request;
import org.example.entities.user.User;
import org.example.valueobjects.Description;
import org.example.valueobjects.Name;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Handler(handler = CreateProjectCommandHandler.class)
public record CreateProjectCommand (
        UUID projectId,
        Name name,
        Description description,
        LocalDate startedLocalDate,
        LocalDate finishedLocalDate,
        User user,
        Set<User> users

) implements Request {
}
