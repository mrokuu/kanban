package org.example.commands.task;

import org.example.BaseController;
import org.example.dtos.TaskDto;
import org.example.dispacher.Mediator;
import org.example.dispacher.response.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskCommandController  extends BaseController  {
    public TaskCommandController(Mediator mediator) {
        super(mediator);
    }

        @PostMapping()
    public ResponseEntity<DataResult<TaskDto>> createTask(@RequestBody CreateTaskCommand command){
            return ResponseEntity.ok(mediator.send(command));
    }


    @PutMapping()
    public ResponseEntity<DataResult<TaskDto>> update(@RequestBody UpdateTaskCommand command){
        return ResponseEntity.ok(mediator.send(command));
    }

}
