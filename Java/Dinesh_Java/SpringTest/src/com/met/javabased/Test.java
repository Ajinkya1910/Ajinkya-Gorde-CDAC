package com.met.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.met.spring.Address;
import com.met.spring.Employee;

public class Test {

	public static void main(String[] args) {
		
		
		ApplicationContext context = 
					new AnnotationConfigApplicationContext(BeanCreator.class);
		
		
		System.out.println("************POST loading ***************");
		
		Employee employee = context.getBean("employee1", Employee.class);
		System.out.println(employee);
		
		
		Address address = context.getBean("createAddress", Address.class);
		System.out.println(address);
		
		
	}
	
}

