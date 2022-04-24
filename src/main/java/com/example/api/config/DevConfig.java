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
		User u = new User(null, "Vicente", "masculino", "vic45@gmail.com", LocalDate.of(1992, 05, 02), "Aracaju/SE", "Brasil",
				"04288498570", LocalDate.now());
		userRespository.save(u);
		
	}

}
