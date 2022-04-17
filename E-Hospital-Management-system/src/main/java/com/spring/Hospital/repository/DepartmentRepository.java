package com.spring.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Hospital.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
}
