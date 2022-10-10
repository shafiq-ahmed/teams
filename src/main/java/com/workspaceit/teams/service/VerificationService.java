package com.workspaceit.teams.service;

import com.workspaceit.teams.entity.InviteStatus;
import com.workspaceit.teams.entity.User;
import com.workspaceit.teams.entity.VerificationData;
import com.workspaceit.teams.repo.UserRepo;
import com.workspaceit.teams.repo.VerificationDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Random;

@Service
public class VerificationService {
    @Autowired
    private VerificationDataRepo verificationDataRepo;
    @Autowired
    private UserRepo userRepo;

    public void sendMail(VerificationData verificationData, String userMail){
        User user= userRepo.findByEmail(userMail);
        verificationData.setSenderMail(user);

        verificationData.setVerificationCode(getRandomCode());
        verificationData.setStatus(InviteStatus.PENDING);
        verificationDataRepo.save(verificationData);
    }

    public String getRandomCode(){
        byte[] array = new byte[4];
        new Random().nextBytes(array);

        return new String(array, Charset.forName("UTF-8"));
    }
}
