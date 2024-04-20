package org.example.query.task;

import lombok.RequiredArgsConstructor;
import org.example.repository.task.TaskQueryReposiroty;
import org.example.task.Task;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskQuery {
    private final TaskQueryReposiroty taskQueryReposiroty;

    public List<Task> getAllTasks() {
        return taskQueryReposiroty.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public Task getTask(UUID id) {
        return taskQueryReposiroty.findById(id).orElse(null);
    }
}
