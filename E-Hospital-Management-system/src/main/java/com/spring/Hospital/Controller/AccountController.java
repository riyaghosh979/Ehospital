package com.spring.Hospital.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.Hospital.entity.Account;
import com.spring.Hospital.entity.Admin;
import com.spring.Hospital.entity.Pharmacy;
import com.spring.Hospital.service.AccountService;
import com.spring.Hospital.service.AdminServiceImplementation;
import com.spring.Hospital.service.PharmacyServiceImplementation;
@Controller
@RequestMapping("/account")

public class AccountController {
	private AccountService accountServiceImp;
	private AdminServiceImplementation adminServiceImplementation;
		


		public AccountController(AccountService accountServiceImp,AdminServiceImplementation obj) {
			
			this.accountServiceImp = accountServiceImp;
			adminServiceImplementation=obj;
		}





		@RequestMapping("/index")
		public String account(Model m)
		{

			// get last seen
			String username="";
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
			   username = ((UserDetails)principal).getUsername();
			  String Pass = ((UserDetails)principal).getPassword();
			  System.out.println("One + "+username+"   "+Pass);
			  
			  
			} else {
			 username = principal.toString();
			  System.out.println("Two + "+username);
			}
			
			Admin admin = adminServiceImplementation.findByEmail(username);
			 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date now = new Date();  
		    
		         String log=now.toString();
		    
		         admin.setLastseen(log);
		         
		         adminServiceImplementation.save(admin);
	        
		List<Account> list=accountServiceImp.findAll();
		
		m.addAttribute("name",admin.getFirstName());
		
		m.addAttribute("email",admin.getEmail());
		
		
		m.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		
		// add to the spring model
		m.addAttribute("account", list);
			return "account/index";
			
		}
	@GetMapping("/account-add")
		
		public String AccontAdd(Model m) {
			
			
			// get last seen
			String username="";
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
			   username = ((UserDetails)principal).getUsername();
			  String Pass = ((UserDetails)principal).getPassword();
			  System.out.println("One + "+username+"   "+Pass);
			  
			  
			} else {
			 username = principal.toString();
			  System.out.println("Two + "+username);
			}
			
			Admin admin = adminServiceImplementation.findByEmail(username);
			 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date now = new Date();  
		    
		         String log=now.toString();
		    
		         admin.setLastseen(log);
		         
		         adminServiceImplementation.save(admin);
			
		         Account account=new Account();
			
			m.addAttribute("Account",account);
			
			return "account/account-add";
		}
		
		@PostMapping("/save-account")
		
		public String saveAccount(@ModelAttribute("account") Account account) {
			
			
		
			               

			        // prescription.setDoctor_id(doctor);
			         
			accountServiceImp.save(account);
			
			return "redirect:/account/index";
		}
		
		
		
		
	}