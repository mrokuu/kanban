package org.example.query.user;


import lombok.RequiredArgsConstructor;
import org.example.repository.user.UserQueryRepository;
import org.example.entities.user.User;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserQuery {
    private final UserQueryRepository userQueryRepository;

    public List<User> getAllUsers() {
        return userQueryRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public User getUser(UUID id) {
        return userQueryRepository.findById(id).orElse(null);
    }

//    public User getUserByEmail(String email) {
//        return userQueryRepository.findByEmail(email);
//    }
}
