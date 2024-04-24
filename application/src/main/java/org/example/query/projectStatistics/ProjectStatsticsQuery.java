package org.example.query.projectStatistics;

import lombok.RequiredArgsConstructor;
import org.example.entities.project.Project;
import org.example.entities.projectStatistics.ProjectStatistics;
import org.example.entities.task.Task;
import org.example.query.task.TaskQuery;
import org.example.repository.project.ProjectQueryRepository;
import org.example.repository.task.TaskQueryReposiroty;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectStatsticsQuery {

    private final ProjectQueryRepository projectQueryRepository;
    private final TaskQueryReposiroty taskQueryReposiroty;


    public List<ProjectStatistics> getProjectStats(UUID id) {
        return null;
    }
}
