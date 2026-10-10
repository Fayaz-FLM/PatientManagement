package com.flm.patient.service;

import java.time.LocalDate;
import java.util.List;

import com.flm.patient.dto.PatientResponseDTO;
import com.flm.patient.dto.RegisterPatientRequestDto;
import com.flm.patient.dto.RegisterPatientResponseDTO;

public interface PatientService {
	 RegisterPatientResponseDTO registerPatient(RegisterPatientRequestDto requestDto);
	 
	 public List<PatientResponseDTO> getPatientsByDoctorIdInDateRange(Long doctorId,LocalDate startDate,LocalDate endDate);
}
