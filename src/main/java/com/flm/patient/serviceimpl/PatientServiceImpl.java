
package com.flm.patient.serviceimpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.flm.patient.builder.PatientBuilder;
import com.flm.patient.builder.PatientDTOBuilder;
import com.flm.patient.dao.PatientRepository;
import com.flm.patient.dto.RegisterPatientRequestDto;
import com.flm.patient.dto.RegisterPatientResponseDTO;
import com.flm.patient.model.Patient;
import com.flm.patient.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public RegisterPatientResponseDTO registerPatient(RegisterPatientRequestDto requestDto) {
    	String email = requestDto.getPatientEmail().trim();
        if (patientRepository.existsByEmail(email)){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists!");
        }
        long phoneNumber = Long.parseLong(requestDto.getPatientPhoneNumber());
        if (patientRepository.existsByPhoneNumber(phoneNumber)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Phone Number already exists!");
        }
        
        Patient patient = PatientBuilder.buildPatientFromRegisterPatientRequestDto(requestDto);
        Patient savedPatient = patientRepository.save(patient);
        return PatientDTOBuilder.buildResgisterPatientResponseDTO(savedPatient);
    }
}
