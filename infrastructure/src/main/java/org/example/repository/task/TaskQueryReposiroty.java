package org.example.repository.task;

import org.example.entities.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskQueryReposiroty extends JpaRepository<Task, UUID> {
    List<Task> findAllByUsersId(UUID id);

    List<Task> findAllByProjectId(UUID id);

    List<Task> findAllByProjectIdAndUsersId(UUID projectId, Long userId);
}
