package org.example.command.project;

import lombok.RequiredArgsConstructor;
import org.example.project.Project;
import org.example.repository.project.ProjectCommandRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectCommand {

    private final ProjectCommandRepository projectCommandRepository;
    public Project createProject(Project project) {
        return projectCommandRepository.save(project);
    }

    public Project updateProject(Project project) {
        return projectCommandRepository.save(project);
    }
}
