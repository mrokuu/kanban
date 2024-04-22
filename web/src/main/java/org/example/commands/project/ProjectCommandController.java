package org.example.commands.project;


import org.example.BaseController;
import org.example.dtos.ProjectDto;
import org.example.dispacher.Mediator;
import org.example.dispacher.response.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
//@RequiredArgsConstructor
public class ProjectCommandController extends BaseController {
    public ProjectCommandController(Mediator mediator) {
        super(mediator);
    }


    @PostMapping("/create")
    public ResponseEntity<DataResult<ProjectDto>> createProject(@RequestBody CreateProjectCommand command){
    return ResponseEntity.ok(mediator.send(command));
    }

        @PutMapping("/update")
    public ResponseEntity<DataResult<ProjectDto>> updateProject(@RequestBody UpdateProjectCommand command){
      return ResponseEntity.ok(mediator.send(command));
    }
}
