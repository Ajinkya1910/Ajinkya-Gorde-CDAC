package com.met.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="counters")
public class Counter {

	@Id
	@Column(name="ctr_Name")
	private String ctrName;
	
	
	@Column(name="CUR_VAL")
	private int value;


	public String getCtrName() {
		return ctrName;
	}


	public void setCtrName(String ctrName) {
		this.ctrName = ctrName;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
