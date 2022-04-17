package com.spring.Hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.Hospital.entity.Pharmacy;
import com.spring.Hospital.entity.Prescription;
import com.spring.Hospital.entity.User;
import com.spring.Hospital.repository.*;

@Service("PrescriptionService")
public class PrescriptionService {
	
	private PrescriptionRepository prescriptionRepository;
	
	@Autowired
	public PrescriptionService(PrescriptionRepository prescriptionRepository) {
		
		this.prescriptionRepository = prescriptionRepository;
	}
	public  Prescription save(Prescription prescription)
	{
		
		return prescriptionRepository.save(prescription);
	}
	public Prescription findByUser(User user) {
		return prescriptionRepository.findByUser(user);
	}
	
	public List<Prescription> findAll() {
		return prescriptionRepository.findAll();
	}
	
	public void delete(int id)   
	{  
		prescriptionRepository.deleteById(id);  
	} 
	
	//updating a record  
	public void update(Prescription prescription)   
	{  
		prescriptionRepository.save(prescription); 
		
	}  
	

}

