package org.example.query.project;

import lombok.RequiredArgsConstructor;
import org.example.project.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectQueryController {

    private final ProjectQuery projectQuery;


    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> allProjects = projectQuery.getAllProjects();

        return new ResponseEntity<>(allProjects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") UUID id) {
        Project project = projectQuery.getProject(id);

        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
