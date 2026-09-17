package com.flm.patient.dto;

import java.time.LocalDate;

import com.flm.patient.utils.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterPatientResponseDTO {

	private String patientId;
	
	private String patientName;
	
	private Gender gender;
	
	private String patientEmail;
	
	private String patientPhoneNumber;
	
	private LocalDate dateOfBirth;
	 
	private PatientAddressResponseDTO patientAddress;
	
}
