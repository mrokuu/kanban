package org.example.commands.comment;

import org.example.commands.project.CreateProjectCommandHandler;
import org.example.entities.task.Task;
import org.example.entities.user.User;
import org.example.mediator.Handler;
import org.example.mediator.Request;
import org.example.valueobjects.CommentText;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Handler(handler = CreteCommentCommandHandler.class)
public record CreateCommentCommand(

        UUID id,
        CommentText commentText,
        LocalDateTime localDateTime,
        Task task,
        User user
) implements Request {
}
