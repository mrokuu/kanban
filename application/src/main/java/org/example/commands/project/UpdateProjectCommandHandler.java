package org.example.commands.project;

import lombok.RequiredArgsConstructor;
import org.example.dtos.ProjectDto;
import org.example.entities.project.Project;
import org.example.dispacher.RequestHandler;
import org.example.dispacher.response.DataResult;
import org.example.dispacher.response.SuccessDataResult;
import org.example.repository.project.ProjectCommandRepository;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UpdateProjectCommandHandler implements RequestHandler<UpdateProjectCommand, DataResult<ProjectDto>> {

    private final ProjectCommandRepository projectCommandRepository;
    @Override
    public DataResult<ProjectDto> handle(UpdateProjectCommand command) {
         Project project = projectCommandRepository.save(mapToUpdateProject(command));
        return new SuccessDataResult<>(maptoProjectDto(project), "Project has been updated!!!");
    }

    public static ProjectDto maptoProjectDto(Project project) {
        return ProjectDto.builder()
                .projectId(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .startedLocalDate(project.getStartedLocalDate())
                .finishedLocalDate(project.getFinishedLocalDate())
                .users(project.getUsers())
                .build();
    }

    public static Project mapToUpdateProject(UpdateProjectCommand command) {
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
