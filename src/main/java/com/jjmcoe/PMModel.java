package com.jjmcoe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PMModel {
	private Integer sn;
	private String patientfullname;
	private Integer age;
	private String gender;
	private String mobilenumber;
	private String password;

}
