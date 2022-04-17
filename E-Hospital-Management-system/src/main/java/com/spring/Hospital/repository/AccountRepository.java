package com.spring.Hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Hospital.entity.Account;
import com.spring.Hospital.entity.Admin;
@Repository("accountRepository")

public interface AccountRepository extends JpaRepository<Account, Integer> {

}