package org.example.repository.project;

import org.example.entities.project.Project;
import org.example.id.ProjectId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectCommandRepository extends JpaRepository<Project, UUID> {
}
