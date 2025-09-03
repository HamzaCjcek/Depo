package com.project.depo_ai.repository.Email;

import com.project.depo_ai.model.Email.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {
    List<VerificationCode> findByEmail(String email);
    void deleteByCreatedAtBefore(LocalDateTime time);
}
