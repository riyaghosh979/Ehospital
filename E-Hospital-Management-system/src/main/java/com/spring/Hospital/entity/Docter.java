package com.spring.Hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Doctor")
public class Docter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doctor_id")
	//AUTO_INCREMENT
	private int doctor_id;
	
	@Column(name = "Docname")
	private String docname;
	
	@Column(name = "username")
	private String username;
	

	@Column(name = "password")
	private String password;
	
	@Column(name = "qualification")
	private String  qualification;
	
	@Column(name = "designation")
	private String  designation;
	
	//Consultation fee
	@Column(name = "Consultation_fee")
	private int  consultation_fee;

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getConsultation_fee() {
		return consultation_fee;
	}

	public void setConsultation_fee(int consultation_fee) {
		this.consultation_fee = consultation_fee;
	}

	@Override
	public String toString() {
		return "Docter [doctor_id=" + doctor_id + ", docname=" + docname + ", username=" + username + ", password="
				+ password + ", qualification=" + qualification + ", designation=" + designation + ", consultation_fee="
				+ consultation_fee + "]";
	}
	
	
	

}
