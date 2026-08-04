package com.riyaz.RestAPIExample.dto;

import com.riyaz.RestAPIExample.types.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddNewStudentDto {
    private String name;
    private String rollNo;
    private String email;
    private Gender gender;
}
