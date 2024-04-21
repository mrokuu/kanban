package org.example.commands.project;

import lombok.RequiredArgsConstructor;
import org.example.dtos.ProjectDto;
import org.example.entities.project.Project;
import org.example.mediator.RequestHandler;
import org.example.mediator.response.DataResult;
import org.example.mediator.response.SuccessDataResult;
import org.example.repository.project.ProjectCommandRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProjectCommandHandler implements RequestHandler<UpdateProjectCommand, DataResult<ProjectDto>> {

    private final ProjectCommandRepository projectCommandRepository;
    @Override
    public DataResult<ProjectDto> handle(UpdateProjectCommand command) {
         Project project = projectCommandRepository.save(mapToProject(command));
        return new SuccessDataResult<>(maptoProjectDto(project), "Project has been updated!!!");
    }


    private ProjectDto maptoProjectDto(Project project) {
        return ProjectDto.builder()
                .projectId(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .numberWip(project.getNumberWip())
                .users(project.getUsers())
                .build();
    }

    private Project mapToProject(UpdateProjectCommand command) {
        return Project.builder()
                .id(command.projectId())
                .name(command.name())
                .description(command.description())
                .numberWip(command.numberWip())
                .leaderUser(command.user())
                .users(command.users())
                .build();
    }
}
