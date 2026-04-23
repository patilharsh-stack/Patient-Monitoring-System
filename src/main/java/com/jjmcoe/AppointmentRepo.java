package com.jjmcoe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  AppointmentRepo  extends JpaRepository<AppointmentEntity , Integer>{
	
	long  countByAppointmentdateAndDoctor(String appointmentdate , String doctor);

	List<AppointmentEntity> findByAppointmentdateAndDoctor(String appointmentdate, String doctor);

	AppointmentEntity findByFullname(String fullname);

	

}
