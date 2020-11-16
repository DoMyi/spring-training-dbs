package com.example.demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderService {
	
	private BCryptPasswordEncoder encoder;
	

	public PasswordEncoderService() {
		this.encoder = new BCryptPasswordEncoder(5);
	}
	
	public String encode(String rawPassword) {
		return encoder.encode(rawPassword);
	}
	
	public boolean matches(String encodedPassword, String rawPassword) {
		return encoder.matches(rawPassword, encodedPassword);
	}

}
