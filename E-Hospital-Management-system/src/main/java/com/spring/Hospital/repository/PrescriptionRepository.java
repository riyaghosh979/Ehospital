package com.spring.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Hospital.entity.Pharmacy;
import com.spring.Hospital.entity.Prescription;
import com.spring.Hospital.entity.User;

@Repository("prescriptionRepository")
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
 Prescription findByUser(User user);
}
