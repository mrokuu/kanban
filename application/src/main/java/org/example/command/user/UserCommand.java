package org.example.command.user;

import lombok.RequiredArgsConstructor;
import org.example.repository.user.UserCommandRepository;
import org.example.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserCommand {
    private final UserCommandRepository userCommandRepository;
    public User createUser(User user) {
        return userCommandRepository.save(user);
    }

    public User updateUser(User user) {
        return userCommandRepository.save(user);
    }
}
