package org.example.repository.comment;

import org.example.entities.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentCommandRepository extends JpaRepository<Comment, UUID> {
}
