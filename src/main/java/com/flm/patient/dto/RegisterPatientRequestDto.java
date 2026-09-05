package com.flm.patient.dto;

import java.time.LocalDate;

public class RegisterPatientRequestDto {
	private String patientName;
    private String gender;
    private String patientEmail;
    private String patientPhoneNumber;
    private LocalDate dateOfBirth;
    private PatientAddressRequestDto patientAddress;

}
