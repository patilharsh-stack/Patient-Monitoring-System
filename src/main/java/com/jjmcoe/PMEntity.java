package com.jjmcoe;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PMEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer sn;
	private String patientfullname;
	private Integer age;
	private String gender;
	private String mobilenumber;
	private String password;
	
	

}
