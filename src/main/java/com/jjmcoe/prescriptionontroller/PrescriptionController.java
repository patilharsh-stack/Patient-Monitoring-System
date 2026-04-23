package com.jjmcoe.prescriptionontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jjmcoe.prescriptionentity.PrescriptionEntity;
import com.jjmcoe.prescriptionmodel.PrescriptionModel;
import com.jjmcoe.prescriptionservice.PrescriptionService;



@Controller
public class PrescriptionController {
	@Autowired
	public PrescriptionService prescriptionservice;
	
	
	
	@GetMapping(value = "/prescription")
	public String createprescription() {
		return "prescription";		
	}	
	@PostMapping("/savepresc")
	public String prescription(@ModelAttribute PrescriptionModel prescriptionModel) {
		prescriptionservice.savepresctodb(prescriptionModel)	;
		return "redirect:/prescription";
	}
	@GetMapping("/history")
	public String gethistory() {
		return "history";
	}
	
	@PostMapping(value = "/gethistory/{name}/{number}")
	public String getpresc(@RequestParam("patientname")String patientname,@RequestParam("mobilenumber")String mobilenumber , ModelMap modelmap) {
		System.out.println(patientname);
		System.out.println(mobilenumber);
		List<PrescriptionEntity> user =prescriptionservice.getrecord(patientname,mobilenumber);
		modelmap.addAttribute("allh",user);
		return "allhistory";		
	}	
	
	
	

}
