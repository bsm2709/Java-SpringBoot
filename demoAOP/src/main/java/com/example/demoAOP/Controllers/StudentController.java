package com.example.demoAOP.Controllers;

import com.example.demoAOP.Entity.Student;
import com.example.demoAOP.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping
    public ResponseEntity<Student> getStudent() throws InterruptedException {
        return ResponseEntity.ok(studentService.fetchStudent());
    }
}
