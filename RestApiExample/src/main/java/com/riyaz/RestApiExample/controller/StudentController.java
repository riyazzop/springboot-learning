package com.riyaz.RestApiExample.controller;

import com.riyaz.RestApiExample.dto.AddStudentReqDto;
import com.riyaz.RestApiExample.dto.StudentDto;
import com.riyaz.RestApiExample.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return  ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentIdFromPath(@PathVariable long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentReqDto  addStudentReqDto){
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.createNewStudent(addStudentReqDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable long id, @RequestBody AddStudentReqDto addStudentReqDto){
        return ResponseEntity.ok( studentService.updateStudentById(id,addStudentReqDto));
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<StudentDto> updatePartialStudent(@PathVariable long id, @RequestBody Map<String,Object> updates){
        return ResponseEntity.ok(studentService.partialUpdateStudentById(id,updates));
    }
}
