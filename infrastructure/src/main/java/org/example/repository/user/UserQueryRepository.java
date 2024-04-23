package org.example.repository.user;

import org.example.entities.user.User;
import org.example.valueobjects.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserQueryRepository extends JpaRepository<User, UUID> {
    User findByEmail(Email email);
//    User findByEmail(String email);
}
