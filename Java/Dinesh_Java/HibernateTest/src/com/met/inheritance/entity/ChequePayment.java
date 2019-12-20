package com.met.inheritance.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
/* @DiscriminatorValue(value="CHEQUE") */
public class ChequePayment extends Payment{

	@Size(max=12)
	private String bankName;
	@Size(max=20)
	private String chequeNo;
	
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	
	
	public ChequePayment(@Size(max = 12) String bankName, @Size(max = 20) String chequeNo, long amount) {
		super(amount);
		
		this.bankName = bankName;
		this.chequeNo = chequeNo;
	}
	public ChequePayment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChequePayment(long amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
