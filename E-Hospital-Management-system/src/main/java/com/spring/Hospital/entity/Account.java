package com.spring.Hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "acc_id")
	private int accId;
	
	
	private boolean payment_status;
	
	private boolean payment_type;

	
	private String bill_details;
	
	private int charges;
	
	public int getAccId() {
		return accId;
	}
	
	
	public boolean isPayment_status() {
		return payment_status;
	}
	public void setPayment_status(boolean payment_status) {
		this.payment_status = payment_status;
	}
	public boolean isPayment_type() {
		return payment_type;
	}
	public void setPayment_type(boolean payment_type) {
		this.payment_type = payment_type;
	}
	
	public String getBill_details() {
		return bill_details;
	}
	public void setBill_details(String bill_details) {
		this.bill_details = bill_details;
	}
	public int getCharges() {
		return charges;
	}
	public void setCharges(int charges) {
		this.charges = charges;
	}
	@Override
	public String toString() {
		return "Account [" + " payment_status=" + payment_status + ", payment_type=" + payment_type
				  + ", bill_details=" + bill_details + ", charges=" + charges
				+ "]";
	}
	
	

}