package org.example.repository.user;

import org.example.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserCommandRepository extends JpaRepository<User, UUID> {
}
