package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.spring.Address;
import com.met.spring.Employee;

public class SpringTest {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("test.xml");
		
		//Object bean = context.getBean("employee1");
		
		
		System.out.println("***************Post App context created *************");
		
		Employee bean = (Employee) context.getBean("employee1");
		System.out.println(bean);
		
		Employee employee = context.getBean("employee1", Employee.class);
		System.out.println("employee1 bean details: " + employee);
		
		Employee employee2 = context.getBean("employee2", Employee.class);
		System.out.println("employee2 bean details: " + employee2);
		
		Employee employee2Test = context.getBean("employee2", Employee.class);
		System.out.println("employee2 bean details: " + employee2Test);
		
		//Prototype beans
		Employee employee3 = context.getBean("employee3", Employee.class);
		System.out.println("employee3 bean details: " + employee3);
		
		Employee employee3Proto = context.getBean("employee3", Employee.class);
		System.out.println("employee3 bean details: " + employee3Proto);
		
		Employee employee4 = context.getBean("employee4", Employee.class);
		System.out.println("employee4 bean details: " + employee4);
		
		Employee employee5 = context.getBean("employee5", Employee.class);
		System.out.println("employee5 bean details: " + employee5);
		
		Employee employee5LazyInit = context.getBean("employee5", Employee.class);
		System.out.println("employee5 bean details: " + employee5LazyInit);
		
		Employee employee6 = context.getBean("employee6", Employee.class);
		System.out.println("employee6 bean details: " + employee6);
		
		Employee employee7 = context.getBean("employee7", Employee.class);
		System.out.println("employee7 bean details: " + employee7);
		
		Employee employee8 = context.getBean("employee8", Employee.class);
		System.out.println("employee8 bean details: " + employee8);
		
		Address address1 = context.getBean("address1", Address.class);
		System.out.println(address1);
		
		
		
	}
	
}
