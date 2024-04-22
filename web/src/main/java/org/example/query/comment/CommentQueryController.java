package org.example.query.comment;

import lombok.RequiredArgsConstructor;
import org.example.entities.comment.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin
@RequiredArgsConstructor
public class CommentQueryController {
    private final CommentQuery commentQuery;

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> allComments = commentQuery.getAllComments();

        return new ResponseEntity<>(allComments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable("id") UUID id) {
        Comment comment = commentQuery.getComment(id);

        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allTask/{id}")
    public ResponseEntity<List<Comment>> findAllByTaskId(@PathVariable("id") UUID id) {
        List<Comment> comments = commentQuery.findAllByTaskId(id);

        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
