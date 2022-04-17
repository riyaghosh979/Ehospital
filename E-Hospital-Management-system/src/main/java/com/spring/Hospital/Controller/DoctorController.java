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
import com.spring.Hospital.entity.Appointment;
import com.spring.Hospital.entity.Labtest;
import com.spring.Hospital.entity.Pharmacy;
import com.spring.Hospital.entity.Prescription;
import com.spring.Hospital.service.AdminServiceImplementation;
import com.spring.Hospital.service.AppointmentServiceImplementation;
import com.spring.Hospital.service.LabtestService;
import com.spring.Hospital.service.PharmacyServiceImplementation;
import com.spring.Hospital.service.PrescriptionService;
//import com.spring.Hospital.service.UserService;
import com.spring.Hospital.service.UserService;


@Controller
@RequestMapping("/doctor")
public class DoctorController {

	//private UserService userService;
	@Autowired
	private LabtestService labtestService;
	
	private AdminServiceImplementation adminServiceImplementation;
	
	private AppointmentServiceImplementation appointmentServiceImplementation;
   
	private PrescriptionService  prescriptionServiceImpl;
	private PharmacyServiceImplementation pharmaServiceImp;
	private UserService userService; 
	@Autowired
	public DoctorController(AdminServiceImplementation obj,
			AppointmentServiceImplementation app,PrescriptionService  prescrip,UserService user, PharmacyServiceImplementation pharma) {
		//this.userService = userService;
		adminServiceImplementation=obj;
		appointmentServiceImplementation=app;
		  prescriptionServiceImpl=prescrip;
		  pharmaServiceImp = pharma;
		  userService =user;
	}
	
	
	@RequestMapping("/index")
	public String index(Model model){

	
		
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
		
		
		         
		List<Appointment> list=appointmentServiceImplementation.findAll();
		
		model.addAttribute("name",admin.getFirstName());
		
		model.addAttribute("email",admin.getEmail());
		
		
		model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		
		// add to the spring model
		model.addAttribute("appointment", list);
		
		return "doctor/index";
	}
	
@GetMapping("/prescription")
	
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
		
		Prescription prescription=new Prescription();
	
		
		m.addAttribute("prescription",prescription);
		//List<Admin> list=adminServiceImplementation.findByRole("ROLE_USER");
		m.addAttribute("user",adminServiceImplementation.findByRole("ROLE_USER"));
		
		return "doctor/prescription";
	}
	
	@PostMapping("/save-prescription")
	
	public String savePrescription(@ModelAttribute("prescription") Prescription prescription) {
		
		
	
		               

		        // prescription.setDoctor_id(doctor);
		//System.out.print(prescription.getUser().getId());
	//	Appointment app= new Appointment();
		//System.out.print(app.getUser());
		//prescription.setUser(app.getUser());
		//Prescription prescrip= 	
		prescriptionServiceImpl.save(prescription);
		//System.out.print(prescrip.getUser().getId());
		
		return "redirect:/doctor/index";
	}
	
	@RequestMapping("/pharmacy")
	public String pharma(Model m)
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
        
	List<Pharmacy> list=pharmaServiceImp.findAll();
	
	m.addAttribute("name",admin.getFirstName());
	
	m.addAttribute("email",admin.getEmail());
	
	
	m.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
	
	// add to the spring model
	m.addAttribute("pharma", list);
		return "doctor/pharmacy";
		
	}
	
	@RequestMapping("/labtests")
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
		return "doctor/labtests";
		
	}
	
	
	
}
