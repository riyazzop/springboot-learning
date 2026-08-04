package com.riyaz.com.HospitalManagement.repository;

import com.riyaz.com.HospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}