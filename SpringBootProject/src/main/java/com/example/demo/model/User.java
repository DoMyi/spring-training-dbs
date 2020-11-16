package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import com.example.demo.service.PasswordEncoderService;

@Entity
public class User {
	
	private String name;
	
	@Id
	private String email;
	private String password;
	
//	@Autowired
//	private PasswordEncoderService encoder;
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}

	
}
