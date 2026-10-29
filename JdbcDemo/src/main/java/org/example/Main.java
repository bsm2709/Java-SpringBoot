package org.example;

import org.example.Entity.Student;
import org.example.Repositories.StudentRepository;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws SQLException {

        StudentRepository studentRepository =new StudentRepository();

        //studentRepository.createStudent(new Student("Santosh" , "Near acharya institute of technology"));
        studentRepository.getStudent(1);
    }
}
