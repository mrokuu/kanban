package org.example.commands.comment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.entities.task.Task;
import org.example.entities.user.User;
import org.example.dispacher.Handler;
import org.example.dispacher.Request;
import org.example.valueobjects.CommentText;

import java.time.LocalDateTime;
import java.util.UUID;
@Handler(handler = UpdateCommentCommandHandler.class)
public record UpdateCommentCommand(

        UUID id,
        @NotNull @Size(min = 1, max = 100) CommentText commentText,
        @NotNull LocalDateTime localDateTime,
        Task task,
        User user
) implements Request {
}
