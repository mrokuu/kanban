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

        @PostMapping("/create")
    public ResponseEntity<DataResult<TaskDto>> createTask(@RequestBody CreateTaskCommand command){
            return ResponseEntity.ok(mediator.send(command));
    }


    @PutMapping("/update")
    public ResponseEntity<DataResult<TaskDto>> update(@RequestBody UpdateTaskCommand command){
        return ResponseEntity.ok(mediator.send(command));
    }

}
