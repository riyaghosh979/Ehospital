package com.spring.Hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "labtest")
public class Labtest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "test_id")
	//AUTO_INCREMENT
	private int testId;
	@Column(name = "test_Name")
	private String testName;
@Column(name = "test_Result")
private String testResult;

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="id",referencedColumnName ="id") 
private User user;

public int getTestId() {
	return testId;
}



public String getTestName() {
	return testName;
}

public void setTestName(String testName) {
	this.testName = testName;
}

public String getTestResult() {
	return testResult;
}

public void setTestResult(String testResult) {
	this.testResult = testResult;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}




}
