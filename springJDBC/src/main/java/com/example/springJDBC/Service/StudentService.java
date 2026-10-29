package com.example.springJDBC.Service;

import com.example.springJDBC.Entity.Student;
import com.example.springJDBC.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student){
        studentRepository.addStudentToDb(student);
    }

    public List<Student> getStudents(){
        return studentRepository.getStudent();
    }
}
