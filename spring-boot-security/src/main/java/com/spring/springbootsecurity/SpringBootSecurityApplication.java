package com.spring.springbootsecurity;

import com.spring.springbootsecurity.entities.User;
import com.spring.springbootsecurity.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityApplication implements CommandLineRunner {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		User user1= new User();
		user1.setId(1);
		user1.setUsername("saqib");
		user1.setEmail("saqib@example.com");
		user1.setPassword(this.passwordEncoder.encode("123456"));
		user1.setRole("ADMIN");

		User user2= new User();
		user2.setId(2);
		user2.setUsername("ali");
		user2.setEmail("ali@example.com");
		user2.setPassword(this.passwordEncoder.encode("12345"));
		user2.setRole("NORMAL");

		userRepository.save(user1);
		userRepository.save(user2);
	}
}
