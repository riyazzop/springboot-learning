package com.riyaz.RestAPIExample.controller;

import com.riyaz.RestAPIExample.dto.AddNewStudentDto;
import com.riyaz.RestAPIExample.dto.StudentDto;
import com.riyaz.RestAPIExample.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> addStudent(@RequestBody AddNewStudentDto addNewStudentDto) {
        StudentDto student = studentService.addStudent(addNewStudentDto);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }



}
