package com.met.manytoone.unidirectional.entity.copy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {		//SOURCE

	@Id
	@GeneratedValue
	private int id;
	@Column(length=15)
	private String city;
	@Column(length=15)
	private String country;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_emp_id")
	private Employee employee;				//Target
	
	public Address(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getId() {
		return id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
