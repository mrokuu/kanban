package org.example.repository.project;

import org.example.entities.project.Project;
import org.example.id.ProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProjectQueryRepository extends JpaRepository<Project, UUID> {
    List<Project> findAllByLeaderUserId(UUID id);

    List<Project> findAllByUsersId(UUID id);
}
