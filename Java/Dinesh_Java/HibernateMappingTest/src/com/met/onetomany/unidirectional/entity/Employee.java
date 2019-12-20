package com.met.onetomany.unidirectional.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Employee {			//Source

	@Id
	@GeneratedValue
	private int id;
	@Column(length=15)
	private String name;
	@Column(length=15)
	private String emailId;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_emp_id")
	private List<Address> listAddress = null;		//target
	
	
	
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

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Address> getListAddress() {
		return listAddress;
	}

	public void setListAddress(List<Address> listAddress) {
		this.listAddress = listAddress;
	}

	public int getId() {
		return id;
	} 

		
}


