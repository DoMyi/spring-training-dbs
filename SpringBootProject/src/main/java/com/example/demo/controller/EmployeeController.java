package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import com.example.demo.service.GsonUtilService;
//import com.google.gson.Gson;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	private GsonUtilService gsonUtilService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
		System.out.println("Hit");
		return "Hello Employee";
	}
	
	@RequestMapping(value = "/fullname", method = RequestMethod.GET)
	public String getFullName(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName) {
		return firstName + " " +lastName;
	}
	
	@RequestMapping(value = "/payroll/{id}", method = RequestMethod.GET)
	public String getEmployee(@PathVariable int id) {
		HashMap<Integer, Employee> emps = new HashMap<>();
		Employee emp = new Employee();
		emps.put(1, new Employee(1, "Sachin", 60000, 3500, 2000, 200));
		emps.put(2, new Employee(2, "Robin", 70000, 3500, 2000, 200));
		
		if(emps.containsKey(id)) {
			emp = emps.get(id);
		}
		
		emp.setGross_sal(emp.getBasic() + emp.getHra() + emp.getAllowance());
		emp.setFinal_deductions((int)(emp.getDeductions() + emp.getGross_sal()*0.2));
		emp.setTotal_sal(emp.getGross_sal() - emp.getFinal_deductions());
		
//		return emp.toString();
//		return (new Gson()).toJson(emp);
		return this.gsonUtilService.simpleJson(emp);
	}
}
