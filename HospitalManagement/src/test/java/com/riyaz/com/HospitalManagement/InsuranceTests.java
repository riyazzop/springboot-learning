package com.riyaz.com.HospitalManagement;

import com.riyaz.com.HospitalManagement.entity.Appointment;
import com.riyaz.com.HospitalManagement.entity.Insurance;
import com.riyaz.com.HospitalManagement.entity.Patient;
import com.riyaz.com.HospitalManagement.repository.PatientRepository;
import com.riyaz.com.HospitalManagement.service.AppointmentService;
import com.riyaz.com.HospitalManagement.service.InsuranceService;
import com.riyaz.com.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public  void testInsuranceAddingFunctionality(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_123")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();
        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);
        var patient1 = insuranceService.removeInsuranceFromPatient(patient.getId());
        System.out.println(patient1);

    }

    @Test
    public  void createNewAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,8,12,5,34))
                .reason("Cancer")
                .build();
        var newAppointment = appointmentService.addNewAppointment(appointment, 1, 2);
        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reAssignAppointmentToNewDoctor(newAppointment.getId(), 3L);
        System.out.println(updatedAppointment);
    }

    @Test
    public void homeworkFromTrainer(){
        Appointment appointment1 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2027,12,12,12,12))
                .reason("Cold and cough")
                .build();
        Appointment appointment2 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2027,12,12,12,12))
                .reason("Fever")
                .build();

        var newAppointment = appointmentService.addNewAppointment(appointment1, 1L, 1L);
        var newAppointment2 = appointmentService.addNewAppointment(appointment2,2L,2L);

        System.out.println(newAppointment);
        System.out.println(newAppointment2);

        patientRepository.findById(1L).ifPresent(patientRepository::delete);
    }
}
