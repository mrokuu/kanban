package org.example.query.comment;

import lombok.RequiredArgsConstructor;
import org.example.entities.comment.Comment;
import org.example.exceptions.CommentNotFoundException;
import org.example.repository.comment.CommentQueryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CommentQuery {

    private final CommentQueryRepository commentQueryRepository;

    public List<Comment> getAllComments() {
            return commentQueryRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public Comment getComment(UUID id) {
        Optional<Comment> comment = commentQueryRepository.findById(id);
        return comment.orElseThrow(() -> new CommentNotFoundException("Comment not found with id: " + id));
    }

    public List<Comment> findAllByTaskId(UUID id) {
        return commentQueryRepository.findAllByTaskIdOrderByLocalDateTimeDesc(id);
    }
}
