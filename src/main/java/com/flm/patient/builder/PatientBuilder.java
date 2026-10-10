package com.flm.patient.builder;

import org.springframework.beans.BeanUtils;

import com.flm.patient.dto.PatientAddressRequestDto;
import com.flm.patient.dto.PatientAddressResponseDTO;
import com.flm.patient.dto.PatientResponseDTO;
import com.flm.patient.dto.RegisterPatientRequestDto;
import com.flm.patient.model.Patient;
import com.flm.patient.model.PatientAddress;

public class PatientBuilder {
	
	public static Patient buildPatientFromRegisterPatientRequestDto(RegisterPatientRequestDto registerPatientRequestDto) {
		return Patient.builder()
				                .name(registerPatientRequestDto.getPatientName())
				                .gender(registerPatientRequestDto.getGender())
				                .email(registerPatientRequestDto.getPatientEmail())
				                .phoneNumber(registerPatientRequestDto.getPatientPhoneNumber())
				                .dateOfBirth(registerPatientRequestDto.getDateOfBirth())
				                .patientAddress(buildPatientAddressFromPatientAddressRequestDto(registerPatientRequestDto.getPatientAddress()))
				 		       .build();
	}

	private static PatientAddress buildPatientAddressFromPatientAddressRequestDto(PatientAddressRequestDto patientAddressRequestDto) {
		 PatientAddress patientAddress=new PatientAddress();
		 BeanUtils.copyProperties(patientAddressRequestDto, patientAddress);
		 return patientAddress;
	}
	
	public static PatientResponseDTO buildPatientResponseDTOFromPatient(Patient patient) {
		
		return PatientResponseDTO
			.builder()
			.patientId(patient.getPatientId())
			.patientEmail(patient.getEmail())
			.patientName(patient.getName())
			.gender(patient.getGender())
			.dateOfBirth(patient.getDateOfBirth())
			.patientPhoneNumber(patient.getPhoneNumber())
			.patientAddress(buildAddressResponseDTOFromPatientAddress(patient.getPatientAddress()))
			.build();
		
	}
	
	public static PatientAddressResponseDTO buildAddressResponseDTOFromPatientAddress(PatientAddress patientAddress) {
		
		return PatientAddressResponseDTO
			.builder()
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
