package com.jjmcoe.prescriptionservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjmcoe.prescriptionentity.PrescriptionEntity;
import com.jjmcoe.prescriptionmodel.PrescriptionModel;
import com.jjmcoe.prescriptionrepo.PrescriptionRepo;

@Service
public class PrescriptionService {
	@Autowired
	public PrescriptionRepo prescriptionrepo;

	public void savepresctodb(PrescriptionModel prescriptionModel) {
		PrescriptionEntity en= new PrescriptionEntity();
		en.setPatientname(prescriptionModel.getPatientname());
		en.setMobilenumber(prescriptionModel.getMobilenumber());
		en.setPrescdate(prescriptionModel.getPrescdate());
		en.setMorningtab(prescriptionModel.getMorningtab());
		en.setAfternoontab(prescriptionModel.getAfternoontab());
		en.setNighttab(prescriptionModel.getNighttab());
		en.setRemark(prescriptionModel.getRemark());
		prescriptionrepo.save(en);	
	}

	public List<PrescriptionEntity>  getrecord() {
		
		return prescriptionrepo.findAll();
	}

	public List<PrescriptionEntity> getrecord(String patientname, String mobilenumber) {
		List<PrescriptionEntity> u1=prescriptionrepo.findByPatientnameAndMobilenumber(patientname,mobilenumber);
		return u1;
	}
	
	
	
}
