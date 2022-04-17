package com.spring.Hospital.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Hospital.entity.Labtest;
import com.spring.Hospital.entity.User;
@Repository("LabtestReposity")
public interface LabtestRepository extends  JpaRepository<Labtest, Integer> {

	Labtest	findByUser(User user);
}
