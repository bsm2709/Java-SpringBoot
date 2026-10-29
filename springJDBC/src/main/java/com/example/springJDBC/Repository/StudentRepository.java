package com.example.springJDBC.Repository;

import com.example.springJDBC.Entity.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    JdbcTemplate jdbcTemplate;

    private RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);



    public StudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addStudentToDb(Student student){
        String Sql = """
                INSERT INTO students(name, address)
                VALUES (?,?);
                """;

        int result = jdbcTemplate.update(Sql,student.getName(),student.getAddress());

        if(result == 1){
            System.out.println("Student added successfully....");
        }
        else {
            System.out.println("Student not added.....");
        }
    }

    public List<Student> getStudent(){
        String Sql = """
                SELECT id, name, address
                FROM students;
                """;

     List<Student> students = jdbcTemplate.query(Sql,rowMapper );

        if(students.isEmpty()){
            System.out.println("No students present");
        }
        else {
            System.out.println("Student Present");
            System.out.println(students);

        }
        return students;
    }
}
