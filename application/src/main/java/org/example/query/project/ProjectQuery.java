package org.example.query.project;

import lombok.RequiredArgsConstructor;
import org.example.entities.project.Project;
import org.example.id.ProjectId;
import org.example.repository.project.ProjectQueryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectQuery {

    private final ProjectQueryRepository projectQueryRepository;
    public List<Project> getAllProjects() {
        return projectQueryRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public Project getProject(ProjectId id) {
        return projectQueryRepository.findById(id).orElse(null);
    }

    public List<Project> findAllByLeaderUserId(ProjectId id) {
        return projectQueryRepository.findAllByLeaderUserId(id);
    }

    public List<Project> findAllByUsersId(ProjectId id) {
        return projectQueryRepository.findAllByUsersId(id);
    }
}
