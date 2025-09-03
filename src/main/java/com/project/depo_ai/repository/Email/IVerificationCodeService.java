package com.project.depo_ai.repository.Email;

public interface IVerificationCodeService {
    String generateAndSaveCode(String email);
}
