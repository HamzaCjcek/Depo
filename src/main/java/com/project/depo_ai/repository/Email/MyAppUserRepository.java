package com.project.depo_ai.repository.Email;

import com.project.depo_ai.model.Email.MyAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyAppUserRepository extends JpaRepository<MyAppUser, Long> {
    Optional<MyAppUser> findByUsername(String username);
    Optional<MyAppUser> findByEmail(String email);
}
