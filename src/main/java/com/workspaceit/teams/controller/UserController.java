package com.workspaceit.teams.controller;

import com.workspaceit.teams.entity.User;
import com.workspaceit.teams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity addUser(User user){
        userService.addUser(user);
        return ResponseEntity.ok("User Created");
    }
}
