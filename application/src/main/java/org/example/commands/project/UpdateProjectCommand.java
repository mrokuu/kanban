package org.example.commands.project;

import org.example.entities.user.User;
import org.example.mediator.Handler;
import org.example.mediator.Request;
import org.example.valueobjects.Description;
import org.example.valueobjects.Name;
import org.example.valueobjects.NumberWip;

import java.util.Set;
import java.util.UUID;
@Handler(handler = UpdateProjectCommandHandler.class)
public record UpdateProjectCommand (
        UUID projectId,
        Name name,
        Description description,
        NumberWip numberWip,
        User user,
        Set<User> users

) implements Request {
}