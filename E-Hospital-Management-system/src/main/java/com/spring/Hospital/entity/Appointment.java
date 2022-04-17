package com.spring.Hospital.entity;

import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;*/
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;


@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "appointment_id")
	private int appointment_id;
	 
	
     //@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	  
	  @JoinColumn(name="id",referencedColumnName ="id")
	  private User user;
	  
	  public User getUser() {
		return user;
	}






	public void setUser(User user) {
		this.user = user;
	}




	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}







	/*  @NotNull
	  
	  @ManyToOne
	 
	 @JoinColumn(name="doctor_id",unique=true) private Docter doctor_id;
	 */
	  
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "appointment_date")
	private String appointment_date;
	
	@ManyToOne(fetch=FetchType.LAZY)
	  
	  @JoinColumn(name="department_id",referencedColumnName ="department_id")
	  private Department department;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "phone")
	private long phone;
	
	@Column(name = "age")
	private String age;
	
	@Column(name = "time")
	private String time;
	
	
	public String getGender() {
		return gender;
	}






	public void setGender(String gender) {
		this.gender = gender;
	}






	public String getTime() {
		return time;
	}






	public void setTime(String time) {
		this.time = time;
	}






	@Column(name = "address")
	private String address;
	
	
	public int getAppointment_id() {
		return appointment_id;
	}

	
	

	

	public String getFirstname() {
		return firstname;
	}






	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}






	public String getLastname() {
		return lastname;
	}






	public void setLastname(String lastname) {
		this.lastname = lastname;
	}






	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAppointment_date() {
		return appointment_date;
	}

	public void setAppointment_date(String appointment_date) {
		this.appointment_date = appointment_date;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}






	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", User=" + user + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", appointment_date=" + appointment_date
				+ ", department=" + department + ", gender=" + gender + ", phone=" + phone + ", age=" + age + ", time="
				+ time + ", address=" + address + "]";
	}





	




	


	
}
