package com.riyaz.RestApiExample.service;

import com.riyaz.RestApiExample.dto.AddStudentReqDto;
import com.riyaz.RestApiExample.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(long id);

    StudentDto createNewStudent(AddStudentReqDto addStudentReqDto);

    void deleteStudentById(long id);

    StudentDto updateStudentById(long id, AddStudentReqDto addStudentReqDto);

    StudentDto partialUpdateStudentById(long id, Map<String, Object> updates);
}
