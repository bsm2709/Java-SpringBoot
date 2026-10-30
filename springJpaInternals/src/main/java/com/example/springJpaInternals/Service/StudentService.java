package com.example.springJpaInternals.Service;

import com.example.springJpaInternals.Entity.Student;
import com.example.springJpaInternals.Repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository =studentRepository;
    }

    //Add student to DB
    @Transactional
    public void addStudentToDB(Student student){
        studentRepository.add(student);
    }

    ///Get student by id
    @Transactional
    public Student getStudentById(long id){
       Student student= studentRepository.getById(id);
       return student;
    }

    //Update Student
    @Transactional
    public Student updateStudentById(long id, Student student){
        Student originalStudent = studentRepository.getById(id);
        if(student == null){
            return null;
        }
        else{
            originalStudent.setStudentName(student.getStudentName());
            originalStudent.setCourse(student.getCourse());
            originalStudent.setPhno(student.getPhno());
            originalStudent.setEmail(student.getEmail());
        }
        return originalStudent;
    }

    @Transactional
    public Student deleteStudentById(Long id){
        Student originalStudent = studentRepository.getById(id);
        if (originalStudent == null){
            return null;
        }
        studentRepository.deleteStudent(id);
        return originalStudent;
    }
}
