package com.project.depo_ai.controller.Email;


import com.project.depo_ai.model.Email.MyAppUser;
import com.project.depo_ai.repository.Email.MyAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class RegistrationController {

    @Autowired
    private MyAppUserRepository myAppUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/req/signup")
    public String signup() {
        return "login/email/signup";
    }

    @PostMapping(value = "/req/signup", consumes = "application/json")
    @ResponseBody // sadece bu method JSON dönsün
    public ResponseEntity<Map<String, String>> createUser(@RequestBody MyAppUser user) {
        Optional<MyAppUser> existingUser = myAppUserRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Bu e-posta adresi zaten kayıtlı.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        myAppUserRepository.save(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Kullanıcı başarıyla oluşturuldu.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
