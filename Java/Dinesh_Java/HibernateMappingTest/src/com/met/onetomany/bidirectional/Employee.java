package com.met.onetomany.bidirectional;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue	
	private int id;
	private String name;
	private String emailId;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="employee")
	private List<Address> listAddress;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String emailId) {
		super();
		this.name = name;
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	

	public int getId() {
		return id;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Address> getListAddress() {
		return listAddress;
	}

	public void setListAddress(List<Address> listAddress) {
		this.listAddress = listAddress;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", emailId=" + emailId + ", listAddress=" + listAddress + "]";
	}
	
	
}
