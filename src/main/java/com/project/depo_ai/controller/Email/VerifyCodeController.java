package com.project.depo_ai.controller.Email;

import com.project.depo_ai.model.Email.VerificationCode;
import com.project.depo_ai.repository.Email.VerificationCodeRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/verify-code")
public class VerifyCodeController {
    private final VerificationCodeRepository verificationCodeRepository;
    @Getter
    private String email;

    @Autowired
    public VerifyCodeController(VerificationCodeRepository verificationCodeRepository) {
        this.verificationCodeRepository = verificationCodeRepository;
    }

    @GetMapping
    public String verifycode()
    {
        return "login/email/verifycode";
    }

    @PostMapping
    public String verifyCode(@RequestParam("email") String email, @RequestParam("code") String code, RedirectAttributes redirectAttributes) {
        // Veritabanında e-posta adresi ile ilgili doğrulama kodunu ara
        List<VerificationCode> verificationCodes = verificationCodeRepository.findByEmail(email);
        this.email = email;
        // Kodun geçerliliğini kontrol et (en son kodu al ve karşılaştır)
        if (verificationCodes.isEmpty() || !verificationCodes.get(verificationCodes.size() - 1).getCode().equals(code)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Geçersiz doğrulama kodu!");
            return "redirect:/verify-code";
        }

        // Başarı durumunda şifre sıfırlama sayfasına yönlendir
        redirectAttributes.addFlashAttribute("successMessage", "Kod doğrulandı. Şifrenizi değiştirebilirsiniz.");
        return "redirect:/req/reset-password";
    }
}
