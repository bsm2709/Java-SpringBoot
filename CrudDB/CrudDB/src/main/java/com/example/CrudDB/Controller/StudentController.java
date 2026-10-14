package com.example.CrudDB.Controller;

import com.example.CrudDB.Entity.Student;
import com.example.CrudDB.Service.StudentService;
import org.hibernate.annotations.SoftDelete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/student")
public class StudentController {

    StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
        System.out.println("controller class constructor");
    }

    //Adding Students
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.status(201).body(studentService.addStudent(student));
    }

//    Gatting all students
    @GetMapping
    public ResponseEntity<List<Student>> readALLStudents(){
        List<Student> students = studentService.getAllStudents();
        if(students == null){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(201).body(studentService.getAllStudents());
    }

    //Getting student by id
    @GetMapping("/{id}")
    public ResponseEntity<Student> readStudent(@PathVariable Long id){
        Student student = studentService.getStudent(id);
        return ResponseEntity.status(201).body(student);
    }

//    Update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                                 @PathVariable Long id){
        return ResponseEntity.status(201).body(studentService.updateStudent(id, student));
    }


//    Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        return ResponseEntity.status(201).body(studentService.deleteStudent(id));
    }

    @PatchMapping("/softDelete/{id}")
    public ResponseEntity<Student> deleteStudentSoft(@PathVariable Long id){

        Student isDeleted = studentService.deleteSoftly(id);
        if(isDeleted == null){
            return ResponseEntity.notFound().build();
        }
        System.out.println("Coming out");
        return ResponseEntity.status(200).body(isDeleted);


    }




}
