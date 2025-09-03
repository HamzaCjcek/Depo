package com.project.depo_ai.repository.Email;

import jakarta.mail.MessagingException;

public interface IEmailService {
    void sendVerificationEmail(String recipient, String verificationCode) throws MessagingException;
}

