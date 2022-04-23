package com.example.api.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.api.entities.User;
import com.example.api.repositories.UserRepository;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRespository;

	@Override
	public void run(String... args) throws Exception {
		User u = new User(null, "Vicente", "masculino", "vic2@gmail.com", LocalDate.now(), "Aracaju/SE", "Brasil",
				"84668032599", LocalDate.now());
		userRespository.save(u);
		
	}

}
