package com.example.CrudDB.Service;

import com.example.CrudDB.Dto.StudentRequestDto;
import com.example.CrudDB.Dto.StudentResponseDto;
import com.example.CrudDB.Entity.Student;
import com.example.CrudDB.ExceptionHandler.ItemNotFound;
import com.example.CrudDB.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    //To check which Profile
    @Value("${message.out}")
    String message;

    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
        System.out.println("Service class constructor");
    }

    public StudentResponseDto addStudent(StudentRequestDto srd){
        Student student = mapToStudent(srd);
        studentRepository.save(student);
        StudentResponseDto studentResponse = mapToStudentResponseDto(student);
        return studentResponse;

    }

    public StudentResponseDto updateStudent(Long id, StudentRequestDto srd){

        Student newStudent = studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(() -> new RuntimeException("Cant find the object with id"+ id));
        newStudent.setStudentName(srd.getStudentName());
        newStudent.setPhno(srd.getPhno());
        newStudent.setAge(srd.getAge());
        newStudent.setAddress(srd.getAddress());
        newStudent.setCourseOpted(srd.getCourseOpted());
        newStudent.setEmail(srd.getEmail());
        newStudent.setUpdatedTime(LocalDateTime.now());

        studentRepository.save(newStudent);

        //map to response dto and return

        return mapToStudentResponseDto(newStudent);
    }

    public List<Student> getAllStudents(){

        return studentRepository.findByDeletedFalse() ;
    }

    public StudentResponseDto getStudent(Long id){

        Student student = studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(() ->new ItemNotFound("Item of ID "+ id+ " not found "));
        return mapToStudentResponseDto(student);
    }

    public String deleteStudent(Long id){
         studentRepository.deleteById(id);
       return ("The id "+ id + " has been Deleted");
    }


    public StudentResponseDto deleteSoftly(Long id){

        Student student = studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(() -> new ItemNotFound("Cant find item to delete"));
        student.setDeleted(true);
        //Update to db
        studentRepository.save(student);
        //map ot responseDto
        StudentResponseDto softlyDeletedStudent = mapToStudentResponseDto(student);
        return softlyDeletedStudent;
    }


    //Convertion
    public Student mapToStudent(StudentRequestDto srd){
        Student student = new Student();

        student.setStudentName(srd.getStudentName());
        student.setAge(srd.getAge());
        student.setPhno(srd.getPhno());
        student.setCourseOpted(srd.getCourseOpted());
        student.setEmail(srd.getEmail());
        student.setAddress(srd.getAddress());
        student.setDeleted(false);

        //Created time
        student.setCreatedTime(LocalDateTime.now());
        student.setUpdatedTime(LocalDateTime.now());

        return  student;

    }



    public StudentResponseDto mapToStudentResponseDto(Student student){
        StudentResponseDto studentResponseDto = new StudentResponseDto();

        studentResponseDto.setStudentName(student.getStudentName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setPhno(student.getPhno());
        studentResponseDto.setCourseOpted(student.getCourseOpted());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setAddress(student.getAddress());
        studentResponseDto.setId(student.getId());


        //Profile checking into response
        studentResponseDto.setCreatedBy(message);

        studentResponseDto.setCreatedTime(student.getCreatedTime());
        studentResponseDto.setUpdatedTime(student.getUpdatedTime());
        return studentResponseDto;
    }


}
