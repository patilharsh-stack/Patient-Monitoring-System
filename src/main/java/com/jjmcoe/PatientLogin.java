package com.jjmcoe;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientLogin {
	private String mobilenumber;
	private String password;

}
