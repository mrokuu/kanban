package org.example.dtos;

import lombok.Builder;
import org.example.entities.user.User;
import org.example.id.ProjectId;
import org.example.valueobjects.Description;
import org.example.valueobjects.Name;
import org.example.valueobjects.NumberWip;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Builder
public record ProjectDto(
        UUID projectId,
        Name name,
        Description description,
        LocalDate startedLocalDate,
        LocalDate finishedLocalDate,
        User user,
        Set<User> users
){
}
