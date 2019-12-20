package com.met.service;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.met.dao.EmployeeDAO;
import com.met.entity.Employee;

//@Component
@Service
public class EmployeeService {

	//private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public void saveEmployee(Employee employee) throws SQLException {
		
		// Do validation here
		
		if(employee.getAge() < 0) {
			
			throw new RuntimeException("Age cannot be < 0");
		}
		
		employeeDAO.saveEmployee(employee);
		
	}
	
	
	public Collection<Employee> getAllEmployees() {
		
		return employeeDAO.getAllEmployees();
		
	}
	
	
}
