package com.met.spring;

public class Employee {

	private static int count;
	
	private int id;
	private int age;
	private String emailId;
	private String designation;
	
	public Employee(int age, String emailId) {
		this();
		this.age = age;
		this.emailId = emailId;
		designation="Fresher";
	}

	public Employee() {
		id = ++count;
		System.out.println("Employee object created with ID: " + id);
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
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", age=" + age + ", designation=" + designation + ", emailId=" + emailId + "]";
	}
	
}
