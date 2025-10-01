package com.abhijeet.outbreakAI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OutbreakAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutbreakAiApplication.class, args);
	}

}
