package com.spring.Hospital.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Hospital.entity.Docter;
import com.spring.Hospital.repository.DoctorRepository;


@Service
public class DoctorServiceImp {

	private DoctorRepository doctorRepository;

	//inject employee dao
	@Autowired   //Adding bean id @Qualifier
	public DoctorServiceImp( DoctorRepository obj)
	{
		doctorRepository=obj;
	}
	

	public List<Docter> findAll() {
		return doctorRepository.findAll();
	}

	
	public void save(Docter Doctor)
	{
		
		doctorRepository.save(Doctor);
	}

	
}
