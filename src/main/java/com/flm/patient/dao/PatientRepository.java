package com.flm.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flm.patient.model.Patient;
@Repository

public interface PatientRepository extends JpaRepository<Patient, Long> {
	

}
