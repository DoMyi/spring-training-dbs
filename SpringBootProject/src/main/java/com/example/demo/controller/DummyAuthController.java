package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
@RequestMapping("/dummyAuth")
public class DummyAuthController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/dummyLogin")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("id").equals("admin") && request.getParameter("password").equals("admin"))
		{
			return "Valid User";
		}
		return "Invalid user";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/dummyRegistration")
	public String register() {
		return "Registration page hit without Authentication!";
	}
}
