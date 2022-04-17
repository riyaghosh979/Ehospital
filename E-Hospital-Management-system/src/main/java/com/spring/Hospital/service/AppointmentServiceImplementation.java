package com.spring.Hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Hospital.entity.Admin;
import com.spring.Hospital.entity.Appointment;
import com.spring.Hospital.entity.Department;
import com.spring.Hospital.repository.AppointmentRepository;


@Service
public class AppointmentServiceImplementation  {

	private AppointmentRepository appointmentRepository;

	//inject employee dao
	@Autowired   //Adding bean id @Qualifier
	public AppointmentServiceImplementation( AppointmentRepository obj)
	{
		appointmentRepository=obj;
	}
	
	
	public void save(Appointment app)
	{
		
		appointmentRepository.save(app);
	}
	
	
	public List<Appointment> findAll() {
		return appointmentRepository.findAll();
	}

	public Appointment findByDepartment(Department depart) {
		return appointmentRepository.findByDepartment( depart);
	}


	/*public Appointment findById(int i) {
		// TODO Auto-generated method stub
		return appointmentRepository.;
	}*/

	
}
