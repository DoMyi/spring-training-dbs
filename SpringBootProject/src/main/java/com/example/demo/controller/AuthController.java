package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.PasswordEncoderService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoderService encoder;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String login(@RequestBody User user) {
		System.out.println("Angular app reached");
		return userService.validateUser(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/register")
	public String register(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userService.registerUser(user);
	}
}
