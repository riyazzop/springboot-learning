package com.riyaz.RestAPIExample.service.impl;

import com.riyaz.RestAPIExample.dto.AddNewStudentDto;
import com.riyaz.RestAPIExample.dto.StudentDto;
import com.riyaz.RestAPIExample.entity.Student;
import com.riyaz.RestAPIExample.repository.StudentRepository;
import com.riyaz.RestAPIExample.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    @Override
    public StudentDto addStudent(AddNewStudentDto studentDto) {
        Student student =  modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }
}
