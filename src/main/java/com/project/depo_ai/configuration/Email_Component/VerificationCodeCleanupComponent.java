package com.project.depo_ai.configuration.Email_Component;

import com.project.depo_ai.repository.Email.VerificationCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class VerificationCodeCleanupComponent {

    private final VerificationCodeRepository verificationCodeRepository;

    @Autowired
    public VerificationCodeCleanupComponent(VerificationCodeRepository verificationCodeRepository) {
        this.verificationCodeRepository = verificationCodeRepository;
    }

    @Scheduled(fixedRate = 600000) // 10 dakika (600000 ms) bir aralıkla çalışacak
    @Transactional
    public void cleanUpOldVerificationCodes() {
        try {
            LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);
            verificationCodeRepository.deleteByCreatedAtBefore(oneHourAgo);
            System.out.println("Eski doğrulama kodları temizlendi.");
        } catch (Exception e) {
            System.err.println("Zamanlayıcı görevinde hata oluştu: " + e.getMessage());
        }
    }
}

