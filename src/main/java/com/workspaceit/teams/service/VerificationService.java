package com.workspaceit.teams.service;

import com.workspaceit.teams.entity.InviteStatus;
import com.workspaceit.teams.entity.User;
import com.workspaceit.teams.entity.VerificationData;
import com.workspaceit.teams.repo.UserRepo;
import com.workspaceit.teams.repo.VerificationDataRepo;
import net.bytebuddy.utility.RandomString;
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

    public String sendMail(VerificationData verificationData, String userMail){
        User user= userRepo.getReferenceById(userMail);
        verificationData.setSenderMail(user);

        verificationData.setVerificationCode(getRandomCode());
        verificationData.setStatus(InviteStatus.PENDING);
        verificationDataRepo.save(verificationData);
        String registrationLink="http://localhost:9090/register/"+verificationData.getVerificationCode();
        return registrationLink;
    }

    public String getRandomCode(){
        return RandomString.make(4);
    }
    public void getEntity(String receiverMail, User senderMail){
       // verificationDataRepo.findByReceiverMailAndSenderMail(receiverMail,senderMail);
    }

    public void getEntityFromId(String receiverMail, String senderMail){
        verificationDataRepo.findByReceiverMailAndSenderMailEmail(receiverMail,senderMail);
    }
}
