package com.riyaz.com.HospitalManagement.service;

import com.riyaz.com.HospitalManagement.entity.Patient;
import com.riyaz.com.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();

        System.out.println(p1 == p2);

        return p1;

    }

    public Patient findByName(String name) {
        Patient patient = patientRepository.findPatientByName(name);
        return patient;
    }
}
