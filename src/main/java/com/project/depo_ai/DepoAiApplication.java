package com.project.depo_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class DepoAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepoAiApplication.class, args);
	}

}
