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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.Hospital.entity.Admin;
//import com.spring.Hospital.entity.Appointment;
import com.spring.Hospital.entity.Pharmacy;
import com.spring.Hospital.entity.Prescription;
import com.spring.Hospital.service.AdminServiceImplementation;
import com.spring.Hospital.service.PharmacyServiceImplementation;

@Controller
@RequestMapping("/pharma")
public class PharmacyController {

	 private PharmacyServiceImplementation pharmaServiceImp;
	
	private AdminServiceImplementation adminServiceImplementation;
	

	@Autowired
	public PharmacyController(PharmacyServiceImplementation pharmaServiceImp,AdminServiceImplementation obj) {
		
		this.pharmaServiceImp = pharmaServiceImp;
		adminServiceImplementation=obj;
	}





	@RequestMapping("/index")
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
		return "pharma/index";
		
	}
@GetMapping("/pharmacy")
	
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
		
	         Pharmacy pharmacy=new Pharmacy();
		
		m.addAttribute("pharmacy",pharmacy);
		
		return "pharma/pharmacy";
	}
	
	@PostMapping("/save-pharmacy")
	
	public String savePrescription(@ModelAttribute("pharmacy") Pharmacy pharmacy) {
		
		
	
		               

		        // prescription.setDoctor_id(doctor);
		         
		pharmaServiceImp.save(pharmacy);
		
		return "redirect:/pharma/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editUpdate(@PathVariable int id,Model m ) {
		m.addAttribute("pharmacy",pharmaServiceImp.getPharmacy(id) );
		return "pharma/edit";
	}
	
	@PostMapping("/update/{id}")
	public String Update(@PathVariable int id ,@ModelAttribute("pharmacy") Pharmacy pharmacy,Model m) {
		Pharmacy pharmacyexit = pharmaServiceImp.getPharmacy(id);
		pharmacyexit.setMedicineName(pharmacy.getMedicineName());
		pharmacyexit.setMedicineCost(pharmacy.getMedicineCost());
		pharmacyexit.setMedicineExpDate(pharmacy.getMedicineExpDate());
		pharmacyexit.setDisease(pharmacy.getDisease());
		pharmaServiceImp.updatePharmacy(pharmacyexit);
		return "redirect:/pharma/index";
	}
	
}
