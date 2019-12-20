package com.met.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.met.spring.Address;
import com.met.spring.Employee;

@Configuration
public class BeanCreator {

	/* <bean id="createEmployee" class="com.met.spring.Employee"> */
	
	
	@Bean("employee1")
	public Employee createEmployee() {
		
		Employee employee = new Employee();
		employee.setAge(22);
		employee.setDesignation("SE");
		
		employee.setAddress(createAddress());
		
		return employee;
		
	}
	
	@Bean
	public Address createAddress() {
		Address address = new Address();
		address.setCity("Mumbai");
		address.setCountry("India");
		
		return address;
	}
	
	
	
}







