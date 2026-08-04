package com.riyaz.RestAPIExample.service;


import com.riyaz.RestAPIExample.dto.AddNewStudentDto;
import com.riyaz.RestAPIExample.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto addStudent(AddNewStudentDto addNewStudentDto);

    List<StudentDto> getAllStudents();
}
