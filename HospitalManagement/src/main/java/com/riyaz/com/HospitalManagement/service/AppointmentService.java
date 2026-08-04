package com.riyaz.com.HospitalManagement.service;

import com.riyaz.com.HospitalManagement.entity.Appointment;
import com.riyaz.com.HospitalManagement.entity.Doctor;
import com.riyaz.com.HospitalManagement.entity.Patient;
import com.riyaz.com.HospitalManagement.repository.AppointmentRepository;
import com.riyaz.com.HospitalManagement.repository.DoctorRepository;
import com.riyaz.com.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    @Transactional
    public Appointment addNewAppointment(Appointment  appointment, long doctorId, long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow();
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment already exists or should not have id field");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment); //bidirectional consistency


        appointmentRepository.save(appointment);
        return appointment;
    }

    @Transactional
    public Appointment reAssignAppointmentToNewDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);
        doctor.getAppointments().add(appointment); // bidirectional consistency
        return appointment;
    }
}
