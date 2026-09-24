package com.flm.patient.model;

import java.time.LocalDate;
import com.flm.patient.utils.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="patient_details")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId ; 
	
	private String name ;
	
	private Gender gender ;
	
	@Column(unique = true, nullable = false)
	private String email ;
	
	private String phoneNumber ; 
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_address_id")
	private PatientAddress patientAddress;
	
	private LocalDate dateOfBirth;

	public Patient(String name, Gender gender, String email, String phoneNumber, PatientAddress patientAddress,
			LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.patientAddress = patientAddress;
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
