package org.example.entities.ProjectStatistics;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.valueobjects.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectStatistics {

    private LocalDate localDate;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "startedTasks", nullable = false))
    })
    private StartedTasks startedTasks;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "activeTasks", nullable = false))
    })
    private ActiveTasks activeTasks;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "startedTasks", nullable = false))
    })
    private FinishedTasks finishedTasks;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "startedTasks", nullable = false))
    })
    private Throughput throughput;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "startedTasks", nullable = false))
    })
    private LeadTime leadTime;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "wip", nullable = false))
    })
    private Wip wip;

}
