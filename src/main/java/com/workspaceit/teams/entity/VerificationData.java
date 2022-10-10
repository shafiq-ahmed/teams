package com.workspaceit.teams.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "verification_table")
public class VerificationData {
    @Id
    private String verificationCode;
    private String receiverMail;
    @ManyToOne
    private User senderMail;

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getReceiverMail() {
        return receiverMail;
    }

    public void setReceiverMail(String receiverMail) {
        this.receiverMail = receiverMail;
    }

    public User getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(User senderMail) {
        this.senderMail = senderMail;
    }
}
