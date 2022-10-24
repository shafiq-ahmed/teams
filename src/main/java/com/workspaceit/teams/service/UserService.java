package com.workspaceit.teams.service;

import com.workspaceit.teams.entity.User;
import com.workspaceit.teams.entity.VerificationData;
import com.workspaceit.teams.repo.UserRepo;
import com.workspaceit.teams.repo.VerificationDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
     @Autowired
     private VerificationDataRepo verificationDataRepo;

    public void addUser(User user){
        userRepo.save(user);
    }

    public void registerUser(String password, String verificationCode){
        VerificationData verificationData= verificationDataRepo.findByVerificationCode(verificationCode);
        User user= new User();
        user.setEmail(verificationData.getReceiverMail());
        user.setPassword(password);
        userRepo.save(user);
    }

    public void getUser(String userMail){
        userRepo.getReferenceById(userMail);
    }
}
