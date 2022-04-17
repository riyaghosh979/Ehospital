package com.spring.Hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Hospital.entity.Account;
import com.spring.Hospital.entity.Admin;
import com.spring.Hospital.repository.AccountRepository;
import com.spring.Hospital.repository.AdminRepository;



	@Service
	public class AccountService  {

		private AccountRepository accountRepository;

		//inject employee dao
		@Autowired   //Adding bean id @Qualifier
		public AccountService( AccountRepository obj)
		{
			accountRepository=obj;
		}
		
		
		public List<Account> findAll() {
			return accountRepository.findAll();
		}

	
		public void save(Account account)
		{
			
			accountRepository.save(account);
		}

		
//		public Account findByEmail(String user) {
//			// TODO Auto-generated method stub
//			
//			return accountRepository.findByEmail(user);
//			
//		}
//
//		@Override
//	//	public List<Account> findByRole(Account account) {
//			
//			return AccountRepository.findByAccount(account);
//		}
//
//
////		public Admin findByDepartment(Department depart) {
//			
//		//	return adminRepository.findByDepartment(depart);
////		}

		
	}