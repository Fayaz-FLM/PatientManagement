package com.flm.patient.utils;

import com.flm.patient.model.Patient;
import jakarta.persistence.PrePersist;

public class PatientEntityListener {
    public static PatientIdGenerator patientIdGenerator;

    public void init(PatientIdGenerator patientIdGenerator) {
        this.patientIdGenerator = patientIdGenerator;
    }

    @PrePersist
    public void generatePatientId(Patient patient) {
        if(null == patient.getPatientId()) {
            patient.setPatientId(patientIdGenerator.generatePatientId());
        }
    }
}
