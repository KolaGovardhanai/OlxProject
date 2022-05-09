package com.zensar.olxlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zensar.olxlogin.entity.OlxLogin;

@SpringBootApplication
public class OlxLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxLoginApplication.class, args);
		
		OlxLogin login = new OlxLogin();
		login.getFirstName();
		login.getLastName();
		login.getUserName();
		login.getPassword();
		login.getEmail();
		login.getPhone();
		login.setPhone(10L);
		
		
	}

}
