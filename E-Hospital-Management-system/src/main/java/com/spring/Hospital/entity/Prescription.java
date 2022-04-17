package com.spring.Hospital.entity;
//import java.util.Set;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;*/
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.NotNull;

@Entity

@Table(name="prescription")

public class Prescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "presc_id")
	private int prescId;
	
	
	  
	  
	  
	 //@NotNull
	  
	  @ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="id",referencedColumnName ="id") 
	  private User user;
	  
	 
	@Column(name = "patient_diseases_deatails") 
	  private String patientDiseasesDeatails;
	@Column(name = "medicine_name")
	  private String medicineName;
	@Column(name = "medicine_course_details") 
	  private String medicineCourseDetails;
	
	
	
	public int getPrescid() {
		return prescId;
	}
	public String getPatientDiseasesDeatails() {
		return patientDiseasesDeatails;
	}
	public void setPatientDiseasesDeatails(String patientDiseasesDeatails) {
		this.patientDiseasesDeatails = patientDiseasesDeatails;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getMedicineCourseDetails() {
		return medicineCourseDetails;
	}
	public void setMedicineCourseDetails(String medicineCourseDetails) {
		this.medicineCourseDetails = medicineCourseDetails;
	}
	@Override
	public String toString() {
		return "Prescription [prescid=" + prescId + ", patientDiseasesDeatails=" + patientDiseasesDeatails
				+ ", medicineName=" + medicineName + ", medicineCourseDetails=" + medicineCourseDetails + ", user=" + user +"]";
	}
	
	
	 
	/*public Doctor getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Doctor doctor_id) {
		this.doctor_id = doctor_id;
	}*/

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	  
	//", doctor_id=" + doctor_id 
	  
	 

}
