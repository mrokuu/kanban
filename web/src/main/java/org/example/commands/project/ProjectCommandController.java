package org.example.commands.project;


import lombok.RequiredArgsConstructor;
import org.example.BaseController;
import org.example.dtos.ProjectDto;
import org.example.entities.project.Project;
import org.example.mediator.Mediator;
import org.example.mediator.response.DataResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
//@RequiredArgsConstructor
public class ProjectCommandController extends BaseController {
//    private final ProjectCommand projectCommand;

    public ProjectCommandController(Mediator mediator) {
        super(mediator);
    }

//    @PostMapping("/create")
//    public ResponseEntity<Project> createProject(@RequestBody Project project){
//        project = projectCommand.createProject(project);
//
//        if (project != null) {
//            return new ResponseEntity<>(project, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping("/create")
    public ResponseEntity<DataResult<ProjectDto>> createProject(@RequestBody CreateProjectCommand project){
    return ResponseEntity.ok(mediator.send(project));
    }
 

//    @PutMapping("/update")
//    public ResponseEntity<Project> updateProject(@RequestBody Project project){
//        project = projectCommand.updateProject(project);
//
//        if (project != null) {
//            return new ResponseEntity<>(project, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
