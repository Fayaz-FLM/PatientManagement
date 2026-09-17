package com.flm.patient.utils;

import com.flm.patient.dao.PatientRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class PatientIdGenerator {

    private final PatientRepository patientRepository;

    public PatientIdGenerator(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Long generatePatientId() {
        String patientIdDateSequence= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String lastPatientId = patientRepository.findLastPatientId(patientIdDateSequence);

        int nextNumber;
        if(null != lastPatientId && lastPatientId.startsWith(patientIdDateSequence)) {
            String idSuffxStr = lastPatientId.substring(patientIdDateSequence.length());
            nextNumber = Integer.parseInt(idSuffxStr)+1;
        }else {
            nextNumber = 1;
        }
        return Long.parseLong(patientIdDateSequence + String.format("%06d", nextNumber));
    }
}
