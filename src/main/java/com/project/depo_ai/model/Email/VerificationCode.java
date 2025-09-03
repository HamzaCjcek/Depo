package com.project.depo_ai.model.Email;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "verificationcode")
@Getter
@Setter
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String code;
    private LocalDateTime createdAt;

    public VerificationCode() {
    }

    public VerificationCode(String email, String code, LocalDateTime createdAt) {
        this.email = email;
        this.code = code;
        this.createdAt = createdAt;
    }
}


