package com.met.spring;

public class Employee {

	int id;
	String name;
	String Designation;
	
	public Employee() {
		super();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesignation() {
		return Designation;
	}
	
	public void setDesignation(String designation) {
		Designation = designation;
	}
	
	public int getId() {
		return id;
	}
	
}
