package com.flm.patient.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="patient_adress")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientAddressId;
	
	private String landmark;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pincode;

	public PatientAddress(String landmark, String city, String state, String country, String pincode) {
		super();
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	
	

}