package org.example.repository.project;

import org.example.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProjectQueryRepository extends JpaRepository<Project, UUID> {
}
