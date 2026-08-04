package com.riyaz.com.HospitalManagement.service;

import com.riyaz.com.HospitalManagement.entity.Insurance;
import com.riyaz.com.HospitalManagement.entity.Patient;
import com.riyaz.com.HospitalManagement.repository.InsuranceRepository;
import com.riyaz.com.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, long patientId) {
        Patient patient =  patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patient with id: " + patientId + " not found"));
        patient.setInsurance(insurance); //owning side

        insurance.setPatient(patient); //bidirectional consistancy

        return patient;
    }
    @Transactional
    public Patient removeInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(null);
        return patient;
    }
}
