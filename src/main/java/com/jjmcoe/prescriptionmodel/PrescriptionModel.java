package com.jjmcoe.prescriptionmodel;

import com.jjmcoe.prescriptionentity.PrescriptionEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionModel {
	
	private Integer sn;
	private String patientname;
	private String mobilenumber;
	private String prescdate;
	private String morningtab;
	private String afternoontab;
	private String nighttab;
	private String remark;
	

}
