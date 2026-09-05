package com.flm.patient.model;

import java.time.LocalDate;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="patient_details")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId ; 
	
	private String name ;
	
	private String gender ;
	
	@Column(unique = true, nullable = false)
	private String email ;
	
	private long phnnum ; 
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_address_id")
	private PatientAddress patientAddress;
	
	private LocalDate DOB;

	public Patient(String name, String gender, String email, long phnnum, PatientAddress patientAddress,
			LocalDate dOB) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phnnum = phnnum;
		this.patientAddress = patientAddress;
		DOB = dOB;
	}
	
	
}
