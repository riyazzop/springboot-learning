package com.riyaz.com.HospitalManagement.repository;

import com.riyaz.com.HospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}