package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoderService encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GsonUtilService gsonUtilService;

	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	public String validateUser(User user) {
//		System.out.println(user.getPassword());
		User requestedUser = userRepository.findById(user.getEmail()).orElse(null);
//		System.out.println(requestedUser.getName());
		if(requestedUser == null)
		{
			return "Not a registered User";
		}
//		String encodedPassword = encoder.encode(user.getPassword());
//		System.out.println(encodedPassword);
		if(!encoder.matches(requestedUser.getPassword(), user.getPassword()))
		{
			return "Wrong Password";
		}
		return this.gsonUtilService.simpleJson(requestedUser);
	}
	
	public String registerUser(User user) {
//		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user).toString();
	}

}
