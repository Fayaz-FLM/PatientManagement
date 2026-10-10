
package com.flm.patient.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.flm.patient.builder.PatientBuilder;
import com.flm.patient.builder.PatientDTOBuilder;
import com.flm.patient.client.AppointmentFeignClient;
import com.flm.patient.dao.PatientRepository;
import com.flm.patient.dto.PatientResponseDTO;
import com.flm.patient.dto.RegisterPatientRequestDto;
import com.flm.patient.dto.RegisterPatientResponseDTO;
import com.flm.patient.exception.PatientNotFoundException;
import com.flm.patient.model.Patient;
import com.flm.patient.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	private final AppointmentFeignClient appointmentFeignClient;
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository, AppointmentFeignClient appointmentFeignClient) {
        this.patientRepository = patientRepository;
        this.appointmentFeignClient = appointmentFeignClient;
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

	@Override
	public List<PatientResponseDTO> getPatientsByDoctorIdInDateRange(Long doctorId,LocalDate startDate,LocalDate endDate) {
		List<Long> listOfPatientIds = appointmentFeignClient.getPatientsByDoctorIdInDateRange(doctorId, startDate, endDate);
		List<PatientResponseDTO> listOfPatients = new ArrayList<>();
		for(Long patientId : listOfPatientIds) {
			Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException("Patient not found with id : "+patientId));
			PatientResponseDTO patientResponseDTO = PatientBuilder.buildPatientResponseDTOFromPatient(patient);
			listOfPatients.add(patientResponseDTO);
		}
		return listOfPatients;
	}
}
