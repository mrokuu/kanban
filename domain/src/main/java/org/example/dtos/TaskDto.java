package org.example.dtos;

import lombok.Builder;
import org.example.entities.project.Project;
import org.example.entities.user.User;
import org.example.enums.progress.Progress;
import org.example.valueobjects.Description;
import org.example.valueobjects.Name;
import org.example.valueobjects.Priority;

import java.util.Set;
import java.util.UUID;

@Builder
public record TaskDto(
                    UUID id,
                      Name name,
                      Description description,
                      Priority priority,
                      Progress progress,
                      Project project,
                      Set<User> users
) {
}