package org.example.commands.project;


import lombok.RequiredArgsConstructor;
import org.example.project.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectCommandController {
    private final ProjectCommand projectCommand;

    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        project = projectCommand.createProject(project);

        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Project> updateProject(@RequestBody Project project){
        project = projectCommand.updateProject(project);

        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
