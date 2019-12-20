package com.met.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="EmployeeTbl")
public class Employee {

	@Id
	private int id;
	
	private String name;
	private int age;
	private String designation;
	private String emailId;
	
	public Employee() {
		super();
		System.out.println("Employee object created...");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", designation=" + designation + ", emailId="
				+ emailId + "]";
	}
	
}
