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
import com.spring.Hospital.entity.Prescription;
import com.spring.Hospital.entity.User;
import com.spring.Hospital.repository.DepartmentRepository;
import com.spring.Hospital.service.AdminServiceImplementation;
import com.spring.Hospital.service.AppointmentServiceImplementation;
import com.spring.Hospital.service.DepartmentService;
import com.spring.Hospital.service.LabtestService;
import com.spring.Hospital.service.PrescriptionService;
import com.spring.Hospital.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private LabtestService labtestService;
	
	private AppointmentServiceImplementation appointmentServiceImplementation;

	private AdminServiceImplementation adminServiceImplementation;
	
	private PrescriptionService prescriptionService; 
	private UserService userService; 
	private  DepartmentService  departmentService;

	
	@Autowired
	public UserController(AppointmentServiceImplementation appointment,
			AdminServiceImplementation admin, PrescriptionService prescrip,UserService user,DepartmentService  depart) {
		
		appointmentServiceImplementation = appointment;
		adminServiceImplementation = admin;
		prescriptionService = prescrip;
		 userService =user;
		 departmentService=depart;
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
		
		User admin = userService.findByEmail(username);
				 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date now = new Date();  
		    
		         String log=now.toString();
		    
		         admin.setLastseen(log);
		         
		         userService.saveUser(admin);
		
		 
		        Labtest test=labtestService.findByUser(admin);
		     	
		     	model.addAttribute("name",admin.getFirstName());
		     	
		     	model.addAttribute("email",admin.getEmail());
		     	
		     	
		     	model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		     	
		     	// add to the spring model
		     	model.addAttribute("labtest", test);
		         
		         
		         Prescription list =prescriptionService.findByUser(admin);
			 		
			 		model.addAttribute("name",admin.getFirstName());
			 		
			 		model.addAttribute("email",admin.getEmail());
			 		
			 		
			 		model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
			 		
			 		// add to the spring model
			 		model.addAttribute("prescription", list);
					
		Appointment obj=new Appointment();
		 
		 obj.setFirstname(admin.getFirstName());
		 obj.setLastname(admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
			
		 System.out.println(obj);
		 
		 model.addAttribute("appointment",obj);
		 
		// List<User> app =userService.findByRole("ROLE_DOCTOR");
		// System.out.println(app);
			model.addAttribute("user",userService.findByRole("ROLE_DOCTOR"));
			
			model.addAttribute("department",departmentService.findAll() );
		
		return "user/index";
	}
	
	
	
	
	@PostMapping("/save-app")
	public String saveEmploye(@ModelAttribute("appointment") Appointment obj) {
		
		appointmentServiceImplementation.save(obj);
		
	
		// use a redirect to prevent duplicate submissions
		return "redirect:/user/index";
	}

	
	@GetMapping("/about")
	public String about(Model model){
		
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
		
		User admin = userService.findByEmail(username);
		 
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date now = new Date();  
	    
	         String log=now.toString();
	    
	         admin.setLastseen(log);
	         
	         userService.saveUser(admin);
	
	         Labtest test=labtestService.findByUser(admin);
		     	
		     	model.addAttribute("name",admin.getFirstName());
		     	
		     	model.addAttribute("email",admin.getEmail());
		     	
		     	
		     	model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		     	
		     	// add to the spring model
		     	model.addAttribute("labtest", test);
	         
	         
	         Prescription list =prescriptionService.findByUser(admin);
		 		
		 		model.addAttribute("name",admin.getFirstName());
		 		
		 		model.addAttribute("email",admin.getEmail());
		 		
		 		
		 		model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		 		
		 		// add to the spring model
		 		model.addAttribute("prescription", list);
				
	Appointment obj=new Appointment();
	 
	 obj.setFirstname(admin.getFirstName());
	 obj.setLastname(admin.getLastName());
	 
	 obj.setEmail(admin.getEmail());
		
	 System.out.println(obj);
	 
	 model.addAttribute("appointment",obj);
	 
	// List<User> app =userService.findByRole("ROLE_DOCTOR");
	// System.out.println(app);
		model.addAttribute("user",userService.findByRole("ROLE_DOCTOR"));
	
		return "user/about";
	}
	
	
	
	@GetMapping("/contact")
	public String contact(Model model){
		
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
		
		User admin = userService.findByEmail(username);
		 
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date now = new Date();  
	    
	         String log=now.toString();
	    
	         admin.setLastseen(log);
	         
	         userService.saveUser(admin);
	
	 
	         Labtest test=labtestService.findByUser(admin);
		     	
		     	model.addAttribute("name",admin.getFirstName());
		     	
		     	model.addAttribute("email",admin.getEmail());
		     	
		     	
		     	model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		     	
		     	// add to the spring model
		     	model.addAttribute("labtest", test); 
	         
	         Prescription list =prescriptionService.findByUser(admin);
		 		
		 		model.addAttribute("name",admin.getFirstName());
		 		
		 		model.addAttribute("email",admin.getEmail());
		 		
		 		
		 		model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		 		
		 		// add to the spring model
		 		model.addAttribute("prescription", list);
				
	Appointment obj=new Appointment();
	 
	 obj.setFirstname(admin.getFirstName());
	 obj.setLastname(admin.getLastName());
	 
	 obj.setEmail(admin.getEmail());
		
	 System.out.println(obj);
	 
	 model.addAttribute("appointment",obj);
	 
	// List<User> app =userService.findByRole("ROLE_DOCTOR");
	// System.out.println(app);
		model.addAttribute("user",userService.findByRole("ROLE_DOCTOR"));
	
		
		return "user/contact";
	}
	

	@GetMapping("/department-single")
	public String d(Model model){
		
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
		
		User admin = userService.findByEmail(username);
		 
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date now = new Date();  
	    
	         String log=now.toString();
	    
	         admin.setLastseen(log);
	         
	         userService.saveUser(admin);
	
	         Labtest test=labtestService.findByUser(admin);
		     	
		     	model.addAttribute("name",admin.getFirstName());
		     	
		     	model.addAttribute("email",admin.getEmail());
		     	
		     	
		     	model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		     	
		     	// add to the spring model
		     	model.addAttribute("labtest", test);
	         
	         
	         Prescription list =prescriptionService.findByUser(admin);
		 		
		 		model.addAttribute("name",admin.getFirstName());
		 		
		 		model.addAttribute("email",admin.getEmail());
		 		
		 		
		 		model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		 		
		 		// add to the spring model
		 		model.addAttribute("prescription", list);
				
	Appointment obj=new Appointment();
	 
	 obj.setFirstname(admin.getFirstName());
	 obj.setLastname(admin.getLastName());
	 
	 obj.setEmail(admin.getEmail());
		
	 System.out.println(obj);
	 
	 model.addAttribute("appointment",obj);
	 
	// List<User> app =userService.findByRole("ROLE_DOCTOR");
	// System.out.println(app);
		model.addAttribute("user",userService.findByRole("ROLE_DOCTOR"));
	
		
		return "user/department-single";
	}

	@GetMapping("/departments")
	public String dep(Model model){
		
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
		
		User admin = userService.findByEmail(username);
		 
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date now = new Date();  
	    
	         String log=now.toString();
	    
	         admin.setLastseen(log);
	         
	         userService.saveUser(admin);
	
	         Labtest test=labtestService.findByUser(admin);
		     	
		     	model.addAttribute("name",admin.getFirstName());
		     	
		     	model.addAttribute("email",admin.getEmail());
		     	
		     	
		     	model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		     	
		     	// add to the spring model
		     	model.addAttribute("labtest", test);
	         
	         
	         Prescription list =prescriptionService.findByUser(admin);
		 		
		 		model.addAttribute("name",admin.getFirstName());
		 		
		 		model.addAttribute("email",admin.getEmail());
		 		
		 		
		 		model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		 		
		 		// add to the spring model
		 		model.addAttribute("prescription", list);
				
	Appointment obj=new Appointment();
	 
	 obj.setFirstname(admin.getFirstName());
	 obj.setLastname(admin.getLastName());
	 
	 obj.setEmail(admin.getEmail());
		
	 System.out.println(obj);
	 
	 model.addAttribute("appointment",obj);
	 
	// List<User> app =userService.findByRole("ROLE_DOCTOR");
	// System.out.println(app);
		model.addAttribute("user",userService.findByRole("ROLE_DOCTOR"));
	
		
		return "user/departments";
	}

	@GetMapping("/doctor")
	public String doctor(Model model){
		
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
		
		User admin = userService.findByEmail(username);
		 
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date now = new Date();  
	    
	         String log=now.toString();
	    
	         admin.setLastseen(log);
	         
	         userService.saveUser(admin);
	
	         Labtest test=labtestService.findByUser(admin);
		     	
		     	model.addAttribute("name",admin.getFirstName());
		     	
		     	model.addAttribute("email",admin.getEmail());
		     	
		     	
		     	model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		     	
		     	// add to the spring model
		     	model.addAttribute("labtest", test);
	         
	         
	         Prescription list =prescriptionService.findByUser(admin);
		 		
		 		model.addAttribute("name",admin.getFirstName());
		 		
		 		model.addAttribute("email",admin.getEmail());
		 		
		 		
		 		model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		 		
		 		// add to the spring model
		 		model.addAttribute("prescription", list);
				
	Appointment obj=new Appointment();
	 
	 obj.setFirstname(admin.getFirstName());
	 obj.setLastname(admin.getLastName());
	 
	 obj.setEmail(admin.getEmail());
		
	 System.out.println(obj);
	 
	 model.addAttribute("appointment",obj);
	 
	// List<User> app =userService.findByRole("ROLE_DOCTOR");
	// System.out.println(app);
		model.addAttribute("user",userService.findByRole("ROLE_DOCTOR"));
	
		
		return "user/doctor";
	}
}