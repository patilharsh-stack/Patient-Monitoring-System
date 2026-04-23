package com.jjmcoe.doctorscontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jjmcoe.AppointmentEntity;
import com.jjmcoe.doctorsservice.DoctorsService;



@Controller

public class DoctorController {
	@Autowired
	public DoctorsService doctorsservice;
	@GetMapping("/doctor")
	public String doctorhomepage() {
		return "doctor";
	}
	
	@PostMapping(value = "/data")
	public String getHomePage(@RequestParam ("appointmentdate") String appointmentdate, @RequestParam ("doctor") String doctor,       
			ModelMap modelmap) {
		modelmap.addAttribute("enquiry",new AppointmentEntity());
		modelmap.addAttribute("all",doctorsservice.getPatientByDateAndDoctor(appointmentdate, doctor));
		modelmap.addAttribute("title","List of Patients  ");
        return "all";		
	}	
	

}
