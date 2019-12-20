package com.rest.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.met.entity.Employee;
import com.met.service.EmployeeService;

@RestController
public class RestHandlerController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/greeting")
	public @ResponseBody String greeting() {
		
		return "Welcome to Spring REST";
		
	}
	
	@GetMapping("/get/{id}")
	public String getemployee(@PathVariable int id) {
		
		return employeeService.getEmployee(id).toString();
		
	}
	
	@GetMapping(value="/getEmployee/{id}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Employee getemployeeObject(@PathVariable int id) {
		
		return employeeService.getEmployee(id);
		
	}
	
	
	/*
	 * @GetMapping(value="/getEmployeeXML/{id}",
	 * produces=MediaType.APPLICATION_XML_VALUE) public Employee
	 * getemployeeXMLObject(@PathVariable int id) {
	 * 
	 * return employeeService.getEmployee(id);
	 * 
	 * }
	 */
	
	@PostMapping(value="/saveEmployee", consumes="application/json")
	public String saveEmployee(@RequestBody Employee employee) throws SQLException {
		
		employeeService.saveEmployee(employee);
		
		return "SUCCESS";
		
	}
	
	
}




