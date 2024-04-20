package org.example.command.task;

import lombok.RequiredArgsConstructor;
import org.example.task.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskCommandController {

    private final TaskCommand taskCommand;

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        task = taskCommand.createTask(task);

        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        task = taskCommand.updateTask(task);

        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
