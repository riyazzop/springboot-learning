package com.riyaz.com.HospitalManagement.dto;

import com.riyaz.com.HospitalManagement.entity.type.BloodGroupsType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BloodGroupCountResponseEntity {
    private BloodGroupsType bloodGroupsType;
    private long count;
}
