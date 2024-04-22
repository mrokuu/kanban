package org.example.commands.user;

import lombok.RequiredArgsConstructor;
import org.example.dtos.UserDto;
import org.example.entities.user.User;
import org.example.dispacher.RequestHandler;
import org.example.dispacher.response.DataResult;
import org.example.dispacher.response.SuccessDataResult;
import org.example.repository.user.UserQueryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserCommandHandler implements RequestHandler<UpdateUserCommand, DataResult<UserDto>> {
    private final UserQueryRepository userQueryRepository;
    @Override
    public DataResult<UserDto> handle(UpdateUserCommand command) {
        User user = userQueryRepository.save(mapToUser(command));
        return new SuccessDataResult<>(maptoUserDto(user), "Task has been created!!!");
    }

    private User mapToUser(UpdateUserCommand command) {
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
}
