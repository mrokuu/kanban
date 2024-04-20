package org.example.commands.user;

import lombok.RequiredArgsConstructor;
import org.example.repository.user.UserCommandRepository;
import org.example.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

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
