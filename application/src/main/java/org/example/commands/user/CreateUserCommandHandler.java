package org.example.commands.user;

import lombok.RequiredArgsConstructor;
import org.example.commands.task.CreateTaskCommand;
import org.example.dtos.TaskDto;
import org.example.dtos.UserDto;
import org.example.entities.user.User;
import org.example.mediator.RequestHandler;
import org.example.mediator.response.DataResult;
import org.example.mediator.response.SuccessDataResult;
import org.example.repository.user.UserCommandRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserCommandHandler implements RequestHandler<CreateUserCommand, DataResult<UserDto>>  {
    private final UserCommandRepository userCommandRepository;
    @Override
    public DataResult<UserDto> handle(CreateUserCommand command) {
        User user = userCommandRepository.save(mapToUser(command));
        return new SuccessDataResult<>(maptoUserDto(user), "Task has been created!!!");
    }

    private UserDto maptoUserDto(User user) {

        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .projects(user.getProjects())
                .tasks(user.getTasks())
                .registrationDate(user.getRegistrationDate())
                .email(user.getEmail())
                .build();
    }

    private User mapToUser(CreateUserCommand command) {
        return User.builder()
                .id(command.id())
                .name(command.name())
                .tasks(command.tasks())
                .registrationDate(command.registrationDate())
                .email(command.email())
                .password(command.password())
                .projects(command.projects())
                .build();
    }
}
