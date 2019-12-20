package com.met.inheritance.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
/* @DiscriminatorValue(value="CARD") */
public class CardPayment extends Payment{

	@Size(max=10)
	private String agencyType;
	@Size(max=20)
	private String cardNo;
	
	public String getAgencyType() {
		return agencyType;
	}
	public void setAgencyType(String agencyType) {
		this.agencyType = agencyType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	
	
}
