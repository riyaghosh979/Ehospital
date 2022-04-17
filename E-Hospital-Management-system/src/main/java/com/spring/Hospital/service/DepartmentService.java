package com.spring.Hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Hospital.entity.Department;
import com.spring.Hospital.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private DepartmentRepository departmentRepository;

	//inject employee dao
	@Autowired   //Adding bean id @Qualifier
	public DepartmentService( DepartmentRepository obj)
	{
		departmentRepository=obj;
	}
	

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	
	public void save(Department department)
	{
		
		departmentRepository.save(department);
	}
	
	
	
}
