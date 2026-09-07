package com.flm.patient.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPatientResponseDTO {

private String patientId;
	
	private String name;
	
	private String gender;
	
	private String email;
	
	private String phoneNumber;
	
	private LocalDate dateOfBirth;
	 
	private PatientAddressResponseDTO patientAddress;
	
}
