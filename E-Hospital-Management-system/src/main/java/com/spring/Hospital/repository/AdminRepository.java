package com.spring.Hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Hospital.entity.Admin;
import com.spring.Hospital.entity.Department;
import com.spring.Hospital.entity.User;


@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByEmail(String user);
	
//	Admin findByDepartment(Department user);
	
	List<Admin> findByRole(String user);
}