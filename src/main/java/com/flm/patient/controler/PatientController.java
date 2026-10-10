package com.flm.patient.controler;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flm.patient.dto.PatientResponseDTO;
import com.flm.patient.dto.RegisterPatientRequestDto;
import com.flm.patient.dto.RegisterPatientResponseDTO;
import com.flm.patient.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
    private final PatientService patientService;
    
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<RegisterPatientResponseDTO> registerPatient(@RequestBody RegisterPatientRequestDto requestDto) {
       
    	RegisterPatientResponseDTO response = patientService.registerPatient(requestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/getDoctorPatients/{staffId}")
    public ResponseEntity<List<PatientResponseDTO>> getPatientsByDoctorIdInDateRange(@PathVariable(name="staffId") Long doctorId,@RequestParam LocalDate startDate,@RequestParam LocalDate endDate){
    	List<PatientResponseDTO> listOfPatients = patientService.getPatientsByDoctorIdInDateRange(doctorId, startDate, endDate);
    	return new ResponseEntity<>(listOfPatients,HttpStatus.OK);
    }
}
