package com.spring.Hospital.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Hospital.entity.Docter;
//import com.spring.Hospital.entity.Appointment;

@Repository("doctorRepository")
public interface DoctorRepository extends JpaRepository<Docter, Integer>  {

	
	//Doctor findByEmail(String user);

}
