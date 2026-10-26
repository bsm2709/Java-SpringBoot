package com.example.demoAOP.Service;

import com.example.demoAOP.CustomAnnotations.TrackExecutionTime;
import com.example.demoAOP.Entity.Student;
import com.example.demoAOP.Repository.StudentRepository;
import jdk.jfr.Timespan;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Timestamp
    public Student createStudent(Student student){
        return studentRepository.addTODB(student);
    }

    @TrackExecutionTime(ExecutionTime = 3000)
    @Timestamp
    public Student fetchStudent() throws InterruptedException {
        return studentRepository.getFromDB();
    }
}
