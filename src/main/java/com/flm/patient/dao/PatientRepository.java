package com.flm.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flm.patient.model.Patient;
@Repository

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(value = "SELECT p.patient_id FROM patient_details p WHERE p.patient_id LIKE CONCAT(:patientIdDateSequence, '%') ORDER BY p.patient_id DESC LIMIT 1", nativeQuery = true)
	String findLastPatientId(@Param("patientIdDateSequence")String patientIdDateSequence);

}
