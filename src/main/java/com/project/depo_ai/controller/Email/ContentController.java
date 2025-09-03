package com.project.depo_ai.controller.Email;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ContentController {
    @GetMapping("/req/login")
    public String login(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            // Kullanıcı zaten giriş yapmış, ana sayfaya yönlendir.
            return "redirect:/index";
        }
        return "login/email/login"; // Kullanıcı giriş yapmamışsa login sayfasını göster.
    }
    @GetMapping("/index")
    public String home(Model model, Authentication authentication) {
        boolean isLoggedIn = authentication != null && authentication.isAuthenticated();
        model.addAttribute("isLoggedIn", isLoggedIn); // Oturum durumunu şablona gönder
        return "admin/index";
    }
}
