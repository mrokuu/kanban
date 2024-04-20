package org.example.repository.task;

import org.example.entities.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskQueryReposiroty extends JpaRepository<Task, UUID> {
}
