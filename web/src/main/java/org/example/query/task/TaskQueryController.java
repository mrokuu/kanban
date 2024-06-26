package org.example.query.task;


import lombok.RequiredArgsConstructor;
import org.example.entities.task.Task;
import org.example.id.TaskId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskQueryController {
    private final TaskQuery taskQuery;

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> allTasks = taskQuery.getAllTasks();

        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") UUID id) {
        Task task = taskQuery.getTask(id);

        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/allByUser/{id}")
    public ResponseEntity<List<Task>> findAllByUsersId(@PathVariable("id") UUID id) {
        List<Task> tasks = taskQuery.findAllByUsersId(id);

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/allByProject/{id}")
    public ResponseEntity<List<Task>> findAllByProjectId(@PathVariable("id") UUID id) {
        List<Task> tasks = taskQuery.findAllByProjectId(id);

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/allByProjectAndUser/{projectId}/{userId}")
    public ResponseEntity<List<Task>> findAllByProjectIdAndUsersId(@PathVariable("projectId") UUID projectId, @PathVariable("userId") UUID userId) {
        List<Task> tasks = taskQuery.findAllByProjectIdAndUsersId(projectId, userId);

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

}
