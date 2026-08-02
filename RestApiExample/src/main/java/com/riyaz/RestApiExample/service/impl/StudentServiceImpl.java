package com.riyaz.RestApiExample.service.impl;

import com.riyaz.RestApiExample.dto.AddStudentReqDto;
import com.riyaz.RestApiExample.dto.StudentDto;
import com.riyaz.RestApiExample.entity.Student;
import com.riyaz.RestApiExample.repository.StudentRepository;
import com.riyaz.RestApiExample.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = students.stream()
                .map(student -> modelMapper.map(student,StudentDto.class))
                .toList();
        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(("Student nor found with ID : "+id)));
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentReqDto addStudentReqDto) {
        Student newStudent = modelMapper.map(addStudentReqDto,Student.class);
        newStudent = studentRepository.save(newStudent);
        return modelMapper.map(newStudent,StudentDto.class);
    }

    @Override
    public void deleteStudentById(long id) {
        if (!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudentById(long id, AddStudentReqDto addStudentReqDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        modelMapper.map(addStudentReqDto,student);
        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto partialUpdateStudentById(long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        updates.forEach((field,value) -> {
            switch (field){
                case "name": student.setName((String) value); break;
                case "email": student.setEmail((String) value); break;
                default: throw new IllegalArgumentException(field + " not found");
            }
        });
        studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

}
