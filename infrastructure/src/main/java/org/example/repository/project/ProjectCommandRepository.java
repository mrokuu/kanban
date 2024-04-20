package org.example.repository.project;

import org.example.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectCommandRepository extends JpaRepository<Project, UUID> {
}
