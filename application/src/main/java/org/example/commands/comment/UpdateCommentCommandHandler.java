package org.example.commands.comment;

import lombok.RequiredArgsConstructor;
import org.example.dtos.CommentDto;
import org.example.entities.comment.Comment;
import org.example.dispacher.RequestHandler;
import org.example.dispacher.response.DataResult;
import org.example.dispacher.response.SuccessDataResult;
import org.example.repository.comment.CommentCommandRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCommentCommandHandler implements RequestHandler<UpdateCommentCommand, DataResult<CommentDto>> {
    private final CommentCommandRepository commentCommandRepository;
    @Override
    public DataResult<CommentDto> handle(UpdateCommentCommand updateCommentCommand) {
        Comment comment = commentCommandRepository.save(mapToComment(updateCommentCommand));
        return new SuccessDataResult<>(maptoCommentDto(comment), "Comment has been created!!!");
    }

    private CommentDto maptoCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .commentText(comment.getCommentText())
                .localDateTime(comment.getLocalDateTime())
                .task(comment.getTask())
                .user(comment.getUser())
                .build();

    }

    private Comment mapToComment(UpdateCommentCommand command) {
        return Comment.builder()
                .id(command.id())
                .commentText(command.commentText())
                .localDateTime(command.localDateTime())
                .task(command.task())
                .user(command.user())
                .build();
    }
}