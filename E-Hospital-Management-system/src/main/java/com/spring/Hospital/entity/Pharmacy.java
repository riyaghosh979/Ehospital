package com.spring.Hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pharmacy")
public class Pharmacy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pharma_id")
	//AUTO_INCREMENT
	private int pharma_id;
	
	private String medicineName;
	private String medicineCost;
	private String medicineExpDate;
	private String disease;
	
	
	//AUTO_INCREMENT
	public int getPharma_id() {
		return pharma_id;
	}
	
	public String getMedicineName() {
		return medicineName;
	}
	

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getMedicineCost() {
		return medicineCost;
	}
	public void setMedicineCost(String medicineCost) {
		this.medicineCost = medicineCost;
	}
	public String getMedicineExpDate() {
		return medicineExpDate;
	}
	public void setMedicineExpDate(String medicineExpDate) {
		this.medicineExpDate = medicineExpDate;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	@Override
	public String toString() {
		return "Pharmacy [pharma_id=" + pharma_id + ", medicineName=" + medicineName + ", medicineCost=" + medicineCost
				+ ", medicineExpDate=" + medicineExpDate + ", disease=" + disease + "]";
	}

}
