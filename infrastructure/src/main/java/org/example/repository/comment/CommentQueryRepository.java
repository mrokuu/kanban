package org.example.repository.comment;

import org.example.entities.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentQueryRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findAllByTaskIdOrderByLocalDateTimeDesc(UUID id);
}
