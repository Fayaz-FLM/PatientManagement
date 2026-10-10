package com.flm.patient.client;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "AppointmentManagement" , url = "http://localhost:8082")
public interface AppointmentFeignClient {
	
	@GetMapping("/appointments/getPatientsByDoctorId/{staffId}")
    public List<Long> getPatientsByDoctorIdInDateRange(@PathVariable(name="staffId") Long doctorId,@RequestParam LocalDate startDate,@RequestParam LocalDate endDate);
    

}
