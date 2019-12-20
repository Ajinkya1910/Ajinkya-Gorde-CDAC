package com.met.controller;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.met.entity.Employee;
import com.met.service.EmployeeService;


/*<bean id="employeeController" class="com.met.controller.EmployeeController">*/
//@Component
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//private EmployeeService employeeService = new EmployeeService();
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ModelAndView initializeEmployee() {
		
		ModelAndView modelAndView = new ModelAndView("employee");
		
		Employee defaultEmployee = new Employee();
		modelAndView.addObject("employee", defaultEmployee);
	
		Collection<Employee> employees = employeeService.getAllEmployees();
		
		modelAndView.addObject("listEmployees", employees);
		
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView saveEmployee(@ModelAttribute Employee employee ) throws SQLException {
		
		ModelAndView modelAndView = new ModelAndView("employee");
		
		System.out.println(employee);
		
		employeeService.saveEmployee(employee);
		
		Collection<Employee> employees = employeeService.getAllEmployees();
		
		modelAndView.addObject("listEmployees", employees);
		
		return modelAndView;
		
	}
	
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		
		
		ModelAndView modelAndView = new ModelAndView("error");
		
		modelAndView.addObject("exceptionMsg", ex.getMessage());
		
		
		return modelAndView;
		
	}
	
}









