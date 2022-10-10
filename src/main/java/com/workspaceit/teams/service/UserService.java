package com.workspaceit.teams.service;

import com.workspaceit.teams.entity.User;
import com.workspaceit.teams.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void addUser(User user){
        userRepo.save(user);
    }
}
