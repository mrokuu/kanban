package org.example.commands.project;

import lombok.RequiredArgsConstructor;
import org.example.dtos.ProjectDto;
import org.example.entities.project.Project;
import org.example.mediator.RequestHandler;
import org.example.mediator.response.DataResult;
import org.example.mediator.response.SuccessDataResult;
import org.example.repository.project.ProjectCommandRepository;
import org.springframework.stereotype.Service;

import static org.example.mapper.project.ProjectMapper.mapToUpdateProject;
import static org.example.mapper.project.ProjectMapper.maptoProjectDto;

@Service
@RequiredArgsConstructor
public class UpdateProjectCommandHandler implements RequestHandler<UpdateProjectCommand, DataResult<ProjectDto>> {

    private final ProjectCommandRepository projectCommandRepository;
    @Override
    public DataResult<ProjectDto> handle(UpdateProjectCommand command) {
         Project project = projectCommandRepository.save(mapToUpdateProject(command));
        return new SuccessDataResult<>(maptoProjectDto(project), "Project has been updated!!!");
    }



}
