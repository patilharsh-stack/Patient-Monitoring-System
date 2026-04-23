package com.jjmcoe.doctorsservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjmcoe.AppointmentEntity;
import com.jjmcoe.AppointmentRepo;


@Service
public class DoctorsService {
	@Autowired
	public AppointmentRepo appointmentrepo;

	public List<AppointmentEntity>getPatientByDateAndDoctor(String appointmentdate,String doctor) {
		
		 return appointmentrepo.findByAppointmentdateAndDoctor(appointmentdate,doctor); 
	}

}
