package com.spring.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Hospital.entity.Pharmacy;

@Repository("PharmacyRepository")
public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {

	//Pharmacy updatePharmacy(Pharmacy pharma);
	//Pharmacy getPharmacyByPharma_id(int id); 
}
