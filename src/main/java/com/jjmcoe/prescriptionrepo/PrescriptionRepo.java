package com.jjmcoe.prescriptionrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjmcoe.prescriptionentity.PrescriptionEntity;

public interface PrescriptionRepo extends JpaRepository<PrescriptionEntity , Integer> {

	List<PrescriptionEntity> findByPatientnameAndMobilenumber(String patientname, String mobilenumber);

}
