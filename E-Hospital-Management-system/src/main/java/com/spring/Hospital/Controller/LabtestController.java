package com.spring.Hospital.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.Hospital.entity.Admin;
import com.spring.Hospital.entity.Labtest;
import com.spring.Hospital.service.AdminServiceImplementation;
import com.spring.Hospital.service.LabtestService;
import com.spring.Hospital.service.UserService;

@Controller
@RequestMapping("/labtest")
public class LabtestController {
	
	@Autowired
	private AdminServiceImplementation adminServiceImplementation;
	
	
	@Autowired
	private LabtestService labtestService;
	
	@Autowired
	private UserService userService; 
	


	@RequestMapping("/index")
	public String Labtest(Model m)
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
        
	List<Labtest> list=labtestService.findAll();
	
	m.addAttribute("name",admin.getFirstName());
	
	m.addAttribute("email",admin.getEmail());
	
	
	m.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
	
	// add to the spring model
	m.addAttribute("labtest", list);
//	m.addAttribute("user",userService.findByRole("ROLE_USER"));
		return "labtest/index";
		
	}
@GetMapping("/add-labtest")
	
	public String prescription(Model m) {
		
		
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
		
	         Labtest labtest=new Labtest();
		
		m.addAttribute("labtest",labtest);
		m.addAttribute("user",userService.findByRole("ROLE_USER"));
		
		return "labtest/addLabtest";
	}
	
	@PostMapping("/save-labtest")
	
	public String savePrescription(@ModelAttribute("labtest") Labtest labtest) {
		
		
	
		               

		        // prescription.setDoctor_id(doctor);
		         
		labtestService.save(labtest);
		
		return "redirect:/labtest/index";
	}
	
	

}
