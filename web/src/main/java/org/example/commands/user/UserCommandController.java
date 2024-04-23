package org.example.commands.user;

import org.example.BaseController;
import org.example.commands.task.UpdateTaskCommand;
import org.example.dtos.UserDto;
import org.example.dispacher.Mediator;
import org.example.dispacher.response.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserCommandController extends BaseController {
    public UserCommandController(Mediator mediator) {
        super(mediator);
    }

    @PostMapping()
    public ResponseEntity<DataResult<UserDto>> createTask(@RequestBody CreateUserCommand command){
        return ResponseEntity.ok(mediator.send(command));
    }


    @PutMapping()
    public ResponseEntity<DataResult<UserDto>> updateTask(@RequestBody UpdateTaskCommand command){
        return ResponseEntity.ok(mediator.send(command));
    }
}
