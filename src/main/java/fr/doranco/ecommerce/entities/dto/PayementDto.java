package fr.doranco.ecommerce.entities.dto;

import java.util.Date;

public class PayementDto{

	private String holderName;
	
	private String number;

	private String cvcCode;
	
	private Date expirationDate;
	
	
	public PayementDto() {
		// TODO Auto-generated constructor stub
	}

	public String getHolderName() {
		return holderName;
	}


	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getCvcCode() {
		return cvcCode;
	}


	public void setCvcCode(String cvcCode) {
		this.cvcCode = cvcCode;
	}


	public Date getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	@Override
	public String toString() {
		return "PayementDto [holderName=" + holderName + ", number=" + number + ", cvcCode=" + cvcCode
				+ ", expirationDate=" + expirationDate + "]";
	}
	
}
