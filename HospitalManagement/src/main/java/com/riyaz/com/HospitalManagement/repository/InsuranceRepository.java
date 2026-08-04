package com.riyaz.com.HospitalManagement.repository;

import com.riyaz.com.HospitalManagement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}