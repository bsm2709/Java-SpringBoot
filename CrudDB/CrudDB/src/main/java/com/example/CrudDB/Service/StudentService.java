package com.example.CrudDB.Service;

import com.example.CrudDB.Entity.Student;
import com.example.CrudDB.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
        System.out.println("Service class constructor");
    }

    public Student addStudent(Student student){
        student.setDeleted(false);
       return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student){
        boolean isPresent = studentRepository.existsById(id);
        if(!isPresent){
            return null;
        }
        Student newStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        newStudent.setStudentName(student.getStudentName());
        newStudent.setPhno(student.getPhno());
        newStudent.setAge(student.getAge());
        newStudent.setAddress(student.getAddress());
        newStudent.setCourseOpted(student.getCourseOpted());
        newStudent.setEmail(student.getEmail());

        studentRepository.save(newStudent);
        student.setDeleted(true);
        return newStudent;
    }

    public List<Student> getAllStudents(){

        return studentRepository.findByDeletedFalse() ;
    }

    public Student getStudent(Long id){

        return studentRepository.findByIdAndDeletedIsFalse(id);
    }

    public String deleteStudent(Long id){
         studentRepository.deleteById(id);
       return ("The id "+ id + " has been Deleted");
    }

    public Student deleteSoftly(Long id){
        Boolean isPresent = studentRepository.existsById(id);
        if(!isPresent){
            return null;
        }
        Student student = studentRepository.findByIdAndDeletedIsFalse(id);
        student.setDeleted(true);
        //Update to db
        studentRepository.save(student);
        return student;
    }
}
