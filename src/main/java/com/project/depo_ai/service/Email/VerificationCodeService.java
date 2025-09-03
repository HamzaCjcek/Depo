package com.project.depo_ai.service.Email;

import com.project.depo_ai.model.Email.VerificationCode;
import com.project.depo_ai.repository.Email.IVerificationCodeService;
import com.project.depo_ai.repository.Email.VerificationCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
public class VerificationCodeService implements IVerificationCodeService {

    private final VerificationCodeRepository verificationCodeRepository;

    @Autowired
    public VerificationCodeService(VerificationCodeRepository verificationCodeRepository) {
        this.verificationCodeRepository = verificationCodeRepository;
    }

    @Override
    public String generateAndSaveCode(String email) {
        SecureRandom random = new SecureRandom();
        int code = 100000 + random.nextInt(900000);
        String generatedCode = String.valueOf(code);

        // Eski kodları temizle
        verificationCodeRepository.deleteByCreatedAtBefore(LocalDateTime.now().minusHours(1));

        // Yeni kodu kaydet
        VerificationCode verificationCode = new VerificationCode(email, generatedCode, LocalDateTime.now());
        verificationCodeRepository.save(verificationCode);

        return generatedCode;
    }
}
