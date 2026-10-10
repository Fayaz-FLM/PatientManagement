package com.flm.patient.dto;

import java.time.LocalDate;

import com.flm.patient.utils.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponseDTO {
	
	private long patientId;
	
	private String patientName;
	
	private Gender gender;
	
	private String patientEmail;
	
	private String patientPhoneNumber;
	
	private LocalDate dateOfBirth;
	 
	private PatientAddressResponseDTO patientAddress;

}
