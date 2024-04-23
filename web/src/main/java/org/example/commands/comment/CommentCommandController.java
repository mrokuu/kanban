package org.example.commands.comment;

import org.example.BaseController;
import org.example.dtos.CommentDto;
import org.example.dispacher.Mediator;
import org.example.dispacher.response.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin
public class CommentCommandController extends BaseController {
    public CommentCommandController(Mediator mediator) {
        super(mediator);
    }

    @PostMapping()
    public ResponseEntity<DataResult<CommentDto>> createComment(@RequestBody CreateCommentCommand command){
        return ResponseEntity.ok(mediator.send(command));
    }

    @PutMapping()
    public ResponseEntity<DataResult<CommentDto>> updateComment(@RequestBody CreateCommentCommand command){
        return ResponseEntity.ok(mediator.send(command));
    }

}
