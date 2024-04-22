package org.example.dtos;

import lombok.Builder;
import org.example.entities.task.Task;
import org.example.entities.user.User;
import org.example.valueobjects.CommentText;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Builder
public record CommentDto(

        UUID id,
        CommentText commentText,
        LocalDateTime localDateTime,
        Task task,
        User user
) {
}
