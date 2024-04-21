package org.example.mapper.project;

import org.example.commands.project.CreateProjectCommand;
import org.example.commands.project.UpdateProjectCommand;
import org.example.dtos.ProjectDto;
import org.example.entities.project.Project;

public class ProjectMapper {

    public static ProjectDto maptoProjectDto(Project project) {
        return ProjectDto.builder()
                .projectId(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .numberWip(project.getNumberWip())
                .users(project.getUsers())
                .build();
    }

    public static Project mapToUpdateProject(UpdateProjectCommand command) {
        return Project.builder()
                .id(command.projectId())
                .name(command.name())
                .description(command.description())
                .numberWip(command.numberWip())
                .leaderUser(command.user())
                .users(command.users())
                .build();
    }


//    private ProjectDto maptoProjectDto(Project project) {
//        return ProjectDto.builder()
//                .projectId(project.getId())
//                .name(project.getName())
//                .description(project.getDescription())
//                .numberWip(project.getNumberWip())
//                .users(project.getUsers())
//                .build();
//    }

    public static Project mapToCreateProject(CreateProjectCommand command) {
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
