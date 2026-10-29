package com.example.springJDBC.Controller;


import com.example.springJDBC.Entity.Student;
import com.example.springJDBC.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService =studentService;
    }

    @PostMapping()
    public void createStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }
}
