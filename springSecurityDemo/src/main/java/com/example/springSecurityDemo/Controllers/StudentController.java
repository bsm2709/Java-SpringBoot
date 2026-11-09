package com.example.springSecurityDemo.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @GetMapping
    public ResponseEntity<String> getAllStudents(){
        return ResponseEntity.ok("All Students Got");
    }

    @PostMapping
    public ResponseEntity<String> addStudents(){
        return ResponseEntity.ok("Students added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateStudents(){
        return ResponseEntity.ok("Student updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudents(){
        return ResponseEntity.ok("Student Deleted successfully");
    }

    @GetMapping("/csrf")
    public CsrfToken createToken(CsrfToken csrfToken){
        return csrfToken;
    }
}
