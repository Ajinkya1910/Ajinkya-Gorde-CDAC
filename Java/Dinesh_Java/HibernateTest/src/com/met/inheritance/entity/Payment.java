package com.met.inheritance.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;

@Entity

/*
 * @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
 * 
 * @DiscriminatorColumn(name="type")
 * 
 * @DiscriminatorValue(value="CASH")
 */

//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

@Inheritance(strategy=InheritanceType.JOINED)

public class Payment {

	@Id
	@GeneratedValue
	private int pay_id;
	private long amount;
	
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public int getPay_id() {
		return pay_id;
	}
	public Payment(long amount) {
		super();
		this.amount = amount;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
