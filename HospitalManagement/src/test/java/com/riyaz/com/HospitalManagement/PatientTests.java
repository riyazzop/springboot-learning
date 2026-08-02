package com.riyaz.com.HospitalManagement;

import com.riyaz.com.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.riyaz.com.HospitalManagement.entity.Patient;
import com.riyaz.com.HospitalManagement.repository.PatientRepository;
import com.riyaz.com.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import java.time.LocalDate;
import java.util.List;

@SpringBootTest
//@RequiredArgsConstructor
public class PatientTests {
    @Autowired
    private  PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        var patientList = patientRepository.findAll();
        patientList.forEach(System.out::println);
    }

    @Test
    public void testTransactionMethods(){
//        Patient patient = patientService.getPatientById(0L);
//        Patient patient = patientService.findByName("Aarav Sharma");
//        System.out.println(patient);

//        List<Patient> patients = patientRepository.findByEmailOrBirthDate("diya.patel@example.com", LocalDate.of(1988,3,15));
//        patients.forEach(System.out::println);

        List<Patient> patients = patientRepository.findByBirthDateBetweenOrderById(LocalDate.of(1950,01,01),LocalDate.now());
        patients.forEach(System.out::println);
//        List<Patient> patients = patientRepository.findByNameContaining("Di");
//        patients.forEach(System.out::println);
    }
    @Test
    public void testJPQLCustomQueries(){
//        List<Patient> patients = patientRepository.findByBloodGroup(BloodGroupsType.A_POSITIVE);

//        List<Patient> patients = patientRepository.findPatientsBornAfterDate(LocalDate.of(1990,01,01));
        List<BloodGroupCountResponseEntity> patients = patientRepository.countEachBloodGroupType();
        patients.forEach(System.out::println);
    }

    @Test
    public void JPQLNativeQueries(){
        List<Patient> patients = patientRepository.findAllPatients();
        patients.forEach(System.out::println);
    }

    @Test
    public void dataModifyingQueries(){
        int affected = patientRepository.updateNameWithId("Riyaz",1L);
        System.out.println(affected);

    }

    @Test
    public void paginationQueries(){
        Page<Patient> patients = patientRepository.findAllPatientsPagination(PageRequest.of(1,3, Sort.by("name")));
        patients.forEach(System.out::println);
        System.out.println(patients);
    }
}
