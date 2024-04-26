package org.example.dtos;

import lombok.Builder;
import org.example.entities.project.Project;
import org.example.valueobjects.*;

import java.util.UUID;
@Builder
public record ColumnDto(
        UUID id,
        Name name,
        Description description,
        Wip wip,
        IsWip isWip

) {
}
