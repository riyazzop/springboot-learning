package com.riyaz.com.HospitalManagement.repository;

import com.riyaz.com.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.riyaz.com.HospitalManagement.entity.Patient;
import com.riyaz.com.HospitalManagement.entity.type.BloodGroupsType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findPatientByName(String name);
//    Patient findByEmailOrBirthDate(String email);  //doesnt work
    List<Patient> findByEmailOrBirthDate(String email, LocalDate birthdate);

    Patient findByEmail(String email);

    Optional<Patient> findByBirthDate(LocalDate birthdate);

    List<Patient> findByBirthDateBetween(LocalDate start, LocalDate end);

    List<Patient> findByNameContaining(String name);

    List<Patient> findByBirthDateBetweenOrderById(LocalDate of, LocalDate now);

    @Query("select p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupsType bloodGroup);

    @Query("select p from Patient p where birthDate > :birthDate")
    List<Patient> findPatientsBornAfterDate(@Param("birthDate") LocalDate birthDate);

//    @Query("select p.bloodGroup, Count(p) from Patient p group by p.bloodGroup" )
//    List<Object[]> countEachBloodGroupType();
      @Query("select new com.riyaz.com.HospitalManagement.dto.BloodGroupCountResponseEntity( p.bloodGroup, Count(p) ) from Patient p group by p.bloodGroup" )
      List<BloodGroupCountResponseEntity> countEachBloodGroupType();


    @Query(value = "select * from patient",nativeQuery = true)
    List<Patient> findAllPatients();

    @Modifying
    @Transactional
    @Query("update Patient p set p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

    @Query("select p from Patient p")
    Page<Patient> findAllPatientsPagination(Pageable pageable);
}
