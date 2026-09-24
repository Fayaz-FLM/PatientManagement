package com.flm.patient.service;

import com.flm.patient.dto.RegisterPatientRequestDto;
import com.flm.patient.dto.RegisterPatientResponseDTO;

public interface PatientService {
	 RegisterPatientResponseDTO registerPatient(RegisterPatientRequestDto requestDto);
}
