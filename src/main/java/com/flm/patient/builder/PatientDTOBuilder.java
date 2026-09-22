package com.flm.patient.builder;

import com.flm.patient.dto.PatientAddressResponseDTO;
import com.flm.patient.dto.RegisterPatientResponseDTO;
import com.flm.patient.model.Patient;
import com.flm.patient.model.PatientAddress;

public class PatientDTOBuilder {

	public static RegisterPatientResponseDTO buildResgisterPatientResponseDTO(Patient patient) {
		
		return RegisterPatientResponseDTO.builder()
										.patientId(Long.toString(patient.getPatientId()))
										.patientName(patient.getName())
										.gender(patient.getGender())
										.patientEmail(patient.getEmail())
										.patientPhoneNumber(Long.toString(patient.getPhoneNumber()))
										.dateOfBirth(patient.getDateOfBirth())
										.patientAddress(buildPatientAddressResponseDTO(patient.getPatientAddress()))
										.build();
																		
	}
	
	public static PatientAddressResponseDTO buildPatientAddressResponseDTO(PatientAddress patientAddress) {
		
		return PatientAddressResponseDTO.builder()
										.patientAddressId(patientAddress.getPatientAddressId())
										.doorNumber(patientAddress.getDoorNumber())
										.landmark(patientAddress.getLandmark())
										.city(patientAddress.getCity())
										.state(patientAddress.getState())
										.country(patientAddress.getCountry())
										.pinCode(patientAddress.getPincode())
										.build();
										
	}
		
}
