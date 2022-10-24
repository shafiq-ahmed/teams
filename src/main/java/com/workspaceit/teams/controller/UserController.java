package com.workspaceit.teams.controller;

import com.workspaceit.teams.entity.User;
import com.workspaceit.teams.entity.VerificationData;
import com.workspaceit.teams.service.UserService;
import com.workspaceit.teams.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private VerificationService verificationService;

    @PostMapping("/addUser")
    public ResponseEntity addUser(User user){
        userService.addUser(user);
        return ResponseEntity.ok("User Created");
    }
    @PostMapping("/sendMail/{userMail}")
    public ResponseEntity sendMail(VerificationData verificationData, @PathVariable String userMail){

        return ResponseEntity.ok(verificationService.sendMail(verificationData,userMail));
    }

    @PostMapping("/register/{verificationCode}")
    public ResponseEntity registerUser(String password, @PathVariable String verificationCode){
        userService.registerUser(password,verificationCode);
        return ResponseEntity.ok("User created");
    }

    @PostMapping("/addUser/{userMail}")
    public void getUser(@PathVariable String userMail){
        userService.getUser(userMail);
    }

    @PostMapping("/addUser2/{receiverMail}")
    public void getUser(@PathVariable String receiverMail, User user){
        verificationService.getEntity(receiverMail,user);
    }

    @PostMapping("/addUser2/{receiverMail}/{senderMail}")
    public void getUser(@PathVariable String receiverMail, @PathVariable String senderMail){
        verificationService.getEntityFromId(receiverMail,senderMail);
    }
}
