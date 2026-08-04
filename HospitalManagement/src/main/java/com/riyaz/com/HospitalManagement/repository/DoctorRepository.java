package com.riyaz.com.HospitalManagement.repository;

import com.riyaz.com.HospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}