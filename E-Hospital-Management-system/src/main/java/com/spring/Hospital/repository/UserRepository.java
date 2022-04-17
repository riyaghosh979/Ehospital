package com.spring.Hospital.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.Hospital.entity.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {
	
	
	 User findByEmail(String email);
	 User findById(int id);
	 List<User> findByRole(String role);
	
	// User findByConfirmationToken(String confirmationToken);
	 
	  List<User> findAll();
}