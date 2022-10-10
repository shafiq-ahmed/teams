package com.workspaceit.teams.repo;

import com.workspaceit.teams.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    User findByEmail(String email);
}
