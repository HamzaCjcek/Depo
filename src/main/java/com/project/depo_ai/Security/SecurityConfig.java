package com.project.depo_ai.Security;

import com.project.depo_ai.service.Email.MyAppUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private final MyAppUserService appUserService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(httpForm -> {
                    httpForm.loginPage("/req/login")
                            .permitAll()
                            .successHandler((request, response, authentication) -> {
                                // Başarılı giriş sonrasında buraya yönlendirilir.
                                response.sendRedirect("/index");
                            })
                            .failureUrl("/req/login?error=true");
                })
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers(
                            "/chat",
                            "/form",
                            "/form/**",
                            "/api/chart",
                            "/stok-tahminler",
                            "/api/chart/stok",
                            "/yillik_tahminler",
                            "/ciro",
                            "/ciro_tahminler",
                            "/api/stok",
                            "/api/stok/**",
                            "/table",
                            "/req/signup",
                            "/index",
                            "/calendar",
                            "/chart",
                            "/form",
                            "/login/email_css/css/**",
                            "/login/email_css/js/**",
                            "/admin/**",
                            "/req/forgot-password",
                            "/req/reset-password",
                            "/send-html-email",
                            "/verify-code"
                    ).permitAll();
                    registry.anyRequest().authenticated();
                })
                .build();
    }
}


