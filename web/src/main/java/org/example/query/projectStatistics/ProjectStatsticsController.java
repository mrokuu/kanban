package org.example.query.projectStatistics;

import lombok.RequiredArgsConstructor;
import org.example.entities.projectStatistics.ProjectStatistics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/stats/project")
@CrossOrigin
@RequiredArgsConstructor
public class ProjectStatsticsController {

    private final ProjectStatsticsQuery projectStatsticsQuery;

    @GetMapping("/{id}")
    public ResponseEntity<List<ProjectStatistics>> getProjectStats(@PathVariable("id") UUID id) {
        List<ProjectStatistics> projectStats = projectStatsticsQuery.getProjectStats(id);

        return new ResponseEntity<>(projectStats, HttpStatus.OK);
    }
}
