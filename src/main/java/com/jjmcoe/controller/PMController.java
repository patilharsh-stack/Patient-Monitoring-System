package com.jjmcoe.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.service.annotation.GetExchange;

import com.jjmcoe.PMModel;
import com.jjmcoe.PMService;
import com.jjmcoe.PatientLogin;

@Controller
public class PMController {
	@Autowired
	public PMService pmservice;
	
	@GetMapping("/home")
	public String homepage() {
		return "homepage";
	}
	@GetMapping("/")
	public String homepage4() {
		return "welcome";
	}
	@PostMapping("/savedata")
	public String savetodb(@ModelAttribute PMModel pmmodel) {
		
		pmservice.saveintodb( pmmodel);
		return "redirect:/loginpage";
		
	}
	
	@GetMapping("/loginpage")
	public String  homePage1() {
		return "login";
	}
	
	@PostMapping("/checkvaliduser")
	public String  userlogin(@ModelAttribute PatientLogin alumnilogin) {
		
		PMModel userdata = pmservice.userlogin(alumnilogin);
		if(userdata !=null) {	
		
			return "redirect:/ls";	
		}else
			
		return "redirect:/lns";
	}
	@GetMapping("/ls")
	public String  homePage2() {
		return "ls";
	}
	
	@GetMapping("/lns")
	public String  homePage3() {
		return "lns";
	}
	
	@GetMapping("/full")
	public String appointmentfull() {
		return "noapp";
	}
	

}
