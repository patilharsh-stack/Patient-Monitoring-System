package com.jjmcoe.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jjmcoe.AppointmentModel;
import com.jjmcoe.AppointmentService;

@Controller
public class PMController2{
	@Autowired
	public AppointmentService appointmentservice;
	
	
	@PostMapping("/appointment")
	public String savetodb(@ModelAttribute AppointmentModel  appointmentmodel ) {
		String mnumber=appointmentmodel.getMobilenumber();
		String appdate=appointmentmodel.getAppointmentdate();
		String special =appointmentmodel.getDoctor();
		long count =appointmentservice.getcountbydate(appdate,special);
		System.out.println(count);
		if(count < appointmentservice.maxpatient) {
		appointmentservice.saveappointmenttodb( appointmentmodel );
		appointmentservice.sendotp(mnumber);
		return "redirect:/";
		}else {
		return "redirect:/full";
		}		
		
	}
	

}
