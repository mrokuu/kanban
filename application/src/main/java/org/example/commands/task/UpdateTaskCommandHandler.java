package org.example.commands.task;

import lombok.RequiredArgsConstructor;
import org.example.dtos.TaskDto;
import org.example.entities.task.Task;
import org.example.mediator.RequestHandler;
import org.example.mediator.response.DataResult;
import org.example.mediator.response.SuccessDataResult;
import org.example.repository.task.TaskCommandRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTaskCommandHandler implements RequestHandler<UpdateTaskCommand, DataResult<TaskDto>> {

    private final TaskCommandRepository taskCommandRepository;
    @Override
    public DataResult<TaskDto> handle(UpdateTaskCommand command) {

        Task task = taskCommandRepository.save(mapToCreateTask(command));
        return new SuccessDataResult<>(maptoTaskDto(task), "Task has been created!!!");
    }

    private TaskDto maptoTaskDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .description(task.getDescription())
                .name(task.getName())
                .priority(task.getPriority())
                .progress(task.getProgress())
                .project(task.getProject())
                .users(task.getUsers())
                .users(task.getUsers())
                .build();
    }

    private Task mapToCreateTask(UpdateTaskCommand command) {
        return Task.builder()
                .id(command.id())
                .description(command.description())
                .name(command.name())
                .priority(command.priority())
                .users(command.users())
                .progress(command.progress())
                .project(command.project())
                .build();
    }
}
