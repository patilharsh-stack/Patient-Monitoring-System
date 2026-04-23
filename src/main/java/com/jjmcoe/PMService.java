package com.jjmcoe;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class PMService {
	@Autowired
	public PMRepo pmrepo;

	public void saveintodb(PMModel pmmodel) {
		PMEntity entity = new PMEntity();
		entity.setPatientfullname(pmmodel.getPatientfullname());
		entity.setAge(pmmodel.getAge());
		entity.setGender(pmmodel.getGender());
		entity.setMobilenumber(pmmodel.getMobilenumber());
		entity.setPassword(pmmodel.getPassword());
		pmrepo.save(entity);
	}

	
	public PMModel userlogin(PatientLogin  patientlogin) {
		PMEntity userdata  = pmrepo.findByMobilenumberAndPassword(patientlogin.getMobilenumber(), patientlogin.getPassword());
		PMModel alumnidto=null;
		if(userdata != null) {
			 alumnidto = new PMModel();
			alumnidto.setMobilenumber(userdata.getMobilenumber());
			alumnidto.setPassword(userdata.getPassword());	
		}
		return alumnidto;	
	}
	
	}
	
	

