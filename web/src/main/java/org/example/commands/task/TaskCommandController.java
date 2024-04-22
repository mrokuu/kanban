package org.example.commands.task;

import lombok.RequiredArgsConstructor;
import org.example.BaseController;
import org.example.dtos.TaskDto;
import org.example.entities.task.Task;
import org.example.mediator.Mediator;
import org.example.mediator.response.DataResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskCommandController  extends BaseController  {
    public TaskCommandController(Mediator mediator) {
        super(mediator);
    }

//    private final TaskCommand taskCommand;

//    @PostMapping("/create")
//    public ResponseEntity<Task> createTask(@RequestBody Task task){
//        task = taskCommand.createTask(task);
//
//        if (task != null) {
//            return new ResponseEntity<>(task, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

        @PostMapping("/create")
    public ResponseEntity<DataResult<TaskDto>> createTask(@RequestBody CreateTaskCommand command){
            return ResponseEntity.ok(mediator.send(command));
    }

//    @PutMapping("/update")
//    public ResponseEntity<Task> updateTask(@RequestBody Task task){
//        task = taskCommand.updateTask(task);
//
//        if (task != null) {
//            return new ResponseEntity<>(task, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PutMapping("/update")
    public ResponseEntity<DataResult<TaskDto>> update(@RequestBody UpdateTaskCommand command){
        return ResponseEntity.ok(mediator.send(command));
    }

}
