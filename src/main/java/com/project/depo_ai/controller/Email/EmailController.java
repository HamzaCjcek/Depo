package com.project.depo_ai.controller.Email;

import com.project.depo_ai.repository.Email.IEmailService;
import com.project.depo_ai.repository.Email.IVerificationCodeService;
import com.project.depo_ai.repository.Email.MyAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/send-html-email")
public class EmailController {

    private final IEmailService emailService;
    private final IVerificationCodeService codeService;
    private final MyAppUserRepository userRepository;

    @Autowired
    public EmailController(IEmailService emailService,
                           IVerificationCodeService codeService,
                           MyAppUserRepository userRepository) {
        this.emailService = emailService;
        this.codeService = codeService;
        this.userRepository = userRepository;
    }
    @GetMapping
    public String showEmailForm() {
        return "login/email/forgotpassword";
    }
    @PostMapping
    public String sendHtmlEmail(@RequestParam("email") String email, RedirectAttributes redirectAttributes) {
        if (userRepository.findByEmail(email).isEmpty()) {
            redirectAttributes.addFlashAttribute("emailNotFound", "Bu e-posta adresi sistemde kayıtlı değil!");
            return "redirect:/send-html-email";
        }

        try {
            // Kod oluşturma ve kaydetme
            String generatedCode = codeService.generateAndSaveCode(email);

            // Mail gönderme
            emailService.sendVerificationEmail(email, generatedCode);

            redirectAttributes.addFlashAttribute("successMessage", "Şifre sıfırlama kodu gönderildi.");
            return "login/email/verifycode";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "E-posta gönderilirken hata oluştu!");
            return "redirect:/send-html-email";
        }
    }
}
