package com.project.depo_ai.controller.Email;


import com.project.depo_ai.model.Email.MyAppUser;
import com.project.depo_ai.repository.Email.MyAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ResetPasswordController {

    @Autowired
    private MyAppUserRepository myAppUserRepository;

    @Autowired
    private VerifyCodeController verifyCodeController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/req/reset-password")
    public String resetPasswordPage(Model model) {
        model.addAttribute("email", verifyCodeController.getEmail());
        return "login/email/resetpassword";  // return the reset password page
    }
    @GetMapping("/req/forgot-password")
    public String forgotPassword()
    {
        return "login/email/forgotpassword";
    }
    @PostMapping("/req/reset-password")
    public ResponseEntity<Map<String, Object>> resetPassword(@RequestParam("newPassword") String newPassword,
                                                             @RequestParam("confirmPassword") String confirmPassword) {
        Map<String, Object> response = new HashMap<>();

        String email = verifyCodeController.getEmail();
        MyAppUser myAppUser = myAppUserRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        if (!newPassword.equals(confirmPassword)) {
            response.put("success", false);
            response.put("message", "Passwords do not match");
            return ResponseEntity.badRequest().body(response);
        }

        // Update the user's password
        myAppUser.setPassword(passwordEncoder.encode(newPassword));
        myAppUserRepository.save(myAppUser);

        response.put("success", true);
        response.put("message", "Password successfully changed");
        return ResponseEntity.ok(response);
    }
}
