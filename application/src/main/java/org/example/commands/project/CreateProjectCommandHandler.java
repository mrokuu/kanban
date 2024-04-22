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
public class CreateProjectCommandHandler implements RequestHandler<CreateProjectCommand, DataResult<ProjectDto>> {
    private final ProjectCommandRepository projectCommandRepository;

    @Override
    public DataResult<ProjectDto> handle(CreateProjectCommand command) {
        Project project = projectCommandRepository.save(mapToCreateProject(command));
        return new SuccessDataResult<>(maptoProjectDto(project), "Project has been created!!!");
    }


    private ProjectDto maptoProjectDto(Project project) {
        return ProjectDto.builder()
                .projectId(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .startedLocalDate(project.getStartedLocalDate())
                .finishedLocalDate(project.getStartedLocalDate())
                .users(project.getUsers())
                .build();
    }

    public static Project mapToCreateProject(CreateProjectCommand command) {
        return Project.builder()
                .id(command.projectId())
                .name(command.name())
                .description(command.description())
                .startedLocalDate(command.startedLocalDate())
                .finishedLocalDate(command.finishedLocalDate())
                .leaderUser(command.user())
                .users(command.users())
                .build();
    }


}
