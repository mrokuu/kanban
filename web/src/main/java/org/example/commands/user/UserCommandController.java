package org.example.commands.user;

import lombok.RequiredArgsConstructor;
import org.example.BaseController;
import org.example.commands.task.CreateTaskCommand;
import org.example.commands.task.UpdateTaskCommand;
import org.example.dtos.TaskDto;
import org.example.dtos.UserDto;
import org.example.entities.user.User;
import org.example.mediator.Mediator;
import org.example.mediator.response.DataResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserCommandController extends BaseController {
    public UserCommandController(Mediator mediator) {
        super(mediator);
    }

//    private final UserCommand userCommand;

//    @PostMapping("/create")
//    public ResponseEntity<User> createUser(@RequestBody User user){
//        user = userCommand.createUser(user);
//
//        if (user != null) {
//            return new ResponseEntity<>(user, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping("/create")
    public ResponseEntity<DataResult<UserDto>> createTask(@RequestBody CreateUserCommand command){
        return ResponseEntity.ok(mediator.send(command));
    }

//    @PutMapping("/update")
//    public ResponseEntity<User> updateUser(@RequestBody User user){
//        user = userCommand.updateUser(user);
//
//        if (user != null) {
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PutMapping("/update")
    public ResponseEntity<DataResult<UserDto>> updateTask(@RequestBody UpdateTaskCommand command){
        return ResponseEntity.ok(mediator.send(command));
    }
}
