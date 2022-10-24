package com.workspaceit.teams.repo;

import com.workspaceit.teams.entity.User;
import com.workspaceit.teams.entity.VerificationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationDataRepo extends JpaRepository<VerificationData,String> {
    VerificationData findByVerificationCode(String verificationCode);
    //VerificationData findByReceiverMailAndSenderMail(String receiverMail, User senderMail);
    VerificationData findByReceiverMailAndSenderMailEmail(String receiverMail, String senderMailId);
}
