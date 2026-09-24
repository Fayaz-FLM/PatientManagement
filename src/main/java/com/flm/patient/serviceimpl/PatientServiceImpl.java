package com.flm.patient.serviceimpl;
import org.springframework.stereotype.Service;
import com.flm.patient.dto.RegisterPatientRequestDto;
import com.flm.patient.dto.RegisterPatientResponseDTO;
import com.flm.patient.model.Patient;
import com.flm.patient.service.PatientService;
import com.flm.patient.builder.PatientBuilder;
import com.flm.patient.dao.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    
    @Override
    public RegisterPatientResponseDTO registerPatient(RegisterPatientRequestDto requestDto) {
        Patient patient = PatientBuilder.buildPatientFromRegisterPatientRequestDto(requestDto);
        Patient savedPatient = patientRepository.save(patient);
        RegisterPatientResponseDTO response = new RegisterPatientResponseDTO();
        response.setPatientId(String.valueOf(savedPatient.getPatientId()));
        response.setPatientName(savedPatient.getName());
        response.setGender(savedPatient.getGender());
        response.setPatientEmail(savedPatient.getEmail());
        response.setPatientPhoneNumber(String.valueOf(savedPatient.getPhoneNumber()));
        response.setDateOfBirth(savedPatient.getDateOfBirth());
        return response;
    }
}