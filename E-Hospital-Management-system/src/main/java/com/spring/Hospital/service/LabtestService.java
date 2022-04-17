package com.spring.Hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Hospital.entity.Labtest;
import com.spring.Hospital.entity.Prescription;
import com.spring.Hospital.entity.User;
import com.spring.Hospital.repository.LabtestRepository;


@Service("LabtestService")
public class LabtestService {
private LabtestRepository labtestRepository;
	
	@Autowired
	public LabtestService(LabtestRepository pharmacyRepository) {
		
		this.labtestRepository = pharmacyRepository;
	}
	public void save(Labtest pharma)
	{
		
		labtestRepository.save(pharma);
	}
	
	
	public List<Labtest> findAll() {
		return labtestRepository.findAll();
	}

	public Labtest findByUser(User user) {
		return labtestRepository.findByUser(user);
	}
	
	
}
