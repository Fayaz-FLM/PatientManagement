package com.flm.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flm.patient.model.PatientAddress;
@Repository

public interface PatientAddressRepository extends JpaRepository<PatientAddress, Long>{

}
