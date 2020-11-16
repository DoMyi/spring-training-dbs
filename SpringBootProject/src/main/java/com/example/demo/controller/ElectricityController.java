package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ElectricityMeter;
import com.example.demo.service.GsonUtilService;
//import com.google.gson.Gson;

@RestController
@RequestMapping("/electricity")
public class ElectricityController {
	
	@Autowired
	private GsonUtilService gsonUtilService;
	
	@RequestMapping(value = "/electricityBill/{id}", method = RequestMethod.GET)
	public String getElectricityBill(@PathVariable("id") int id) {
		
		HashMap<Integer, ElectricityMeter> elecUsers = new HashMap<Integer, ElectricityMeter>();
		elecUsers.put(18981, new ElectricityMeter(18981, 96, 4.62f, new Date()));
		elecUsers.put(18982, new ElectricityMeter(18982, 102, 4.62f, new Date()));
		elecUsers.put(18983, new ElectricityMeter(18983, 154, 4.62f, new Date()));
		
		ElectricityMeter elecUser = new ElectricityMeter();
		if(elecUsers.containsKey(id)) {
			elecUser = elecUsers.get(id);
		}
		
//		return (new Gson()).toJson(elecUser);
		return this.gsonUtilService.simpleJson(elecUser);
		
	}

	public ElectricityController() {
		// TODO Auto-generated constructor stub
	}

}
