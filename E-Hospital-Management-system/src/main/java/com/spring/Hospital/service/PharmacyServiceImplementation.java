package com.spring.Hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.Hospital.entity.Pharmacy;
import com.spring.Hospital.repository.*;

@Service("PharmacyService")
public class PharmacyServiceImplementation {
	
	private PharmacyRepository pharmacyRepository;
	
	@Autowired
	public PharmacyServiceImplementation(PharmacyRepository pharmacyRepository) {
		
		this.pharmacyRepository = pharmacyRepository;
	}
	public void save(Pharmacy pharma)
	{
		
		pharmacyRepository.save(pharma);
	}
	
	
	public List<Pharmacy> findAll() {
		return pharmacyRepository.findAll();
	}
	
	public void delete(int id)   
	{  
		pharmacyRepository.deleteById(id);  
	} 
	
	//updating a record  
	public Pharmacy updatePharmacy(Pharmacy pharmacy)   
	{  
		return pharmacyRepository.save(pharmacy) ;
		
	}  
	
	public Pharmacy getPharmacy(int id)   
	{  
		return pharmacyRepository.findById(id).get();
		
	}  
	

}
