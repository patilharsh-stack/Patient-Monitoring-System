package com.jjmcoe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentModel {
	private Integer sn;
	private String fullname;
	private Integer age;
	private String gender;
	private String mobilenumber;
	private String doctor;
	private String appointmentdate;
	
	

}
