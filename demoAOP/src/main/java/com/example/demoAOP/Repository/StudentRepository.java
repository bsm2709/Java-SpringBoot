package com.example.demoAOP.Repository;

import com.example.demoAOP.Entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    Student returnstudent = new Student();
    Student hardCodedStudent = new Student();

    public Student addTODB(Student student){
        returnstudent.setStudentName(student.getStudentName());
        returnstudent.setAge(student.getAge());

        return returnstudent;
    }

    public Student getFromDB() throws InterruptedException {
        hardCodedStudent.setStudentName("Santosh Meti");
        hardCodedStudent.setAge(25);
         try{
             Thread.sleep(2000);
         }
         catch (Exception ex){};


        return hardCodedStudent;
    }
}
