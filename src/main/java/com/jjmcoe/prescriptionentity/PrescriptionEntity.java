package com.jjmcoe.prescriptionentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PrescriptionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sn;
	private String patientname;
	private String mobilenumber;
	private String prescdate;
	private String morningtab;
	private String afternoontab;
	private String nighttab;
	private String remark;

}
