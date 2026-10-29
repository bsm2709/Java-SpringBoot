package org.example.Repositories;

import org.example.Entity.Student;

import java.sql.*;

public class StudentRepository {

    public String url = "jdbc:mysql://localhost:3306/jdbcdemo";
    public String username = "root";
    public String password = "Santoshmeti@1234..";

    public void createStudent(Student student) throws SQLException {

        String sql = """
                     INSERT INTO students(name,address)
                     VALUES (?,?);
                     """;

        try(
                Connection connection = DriverManager.getConnection(url,username,password);

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ){
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getAddress());

                int resultSet = preparedStatement.executeUpdate();

                if(resultSet == 1){
                    System.out.println("Student added to db Successfully");
                }
                else{
                    System.out.println("Error in adding student");
                }

        }

    }

    public void getStudent(long id) throws SQLException {

        String sql = """
                     SELECT id, name, address
                     FROM students
                     WHERE id = ?;
                     """;

        try(
                Connection connection = DriverManager.getConnection(url,username,password);

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setLong(1, id);


            ResultSet resultSet =preparedStatement.executeQuery();

            if(resultSet.next()){
                Student student = mapTOStudent(resultSet);
                System.out.println("Student Got is: ");
                System.out.println(student);
            }
            else{
                System.out.println("Error in getting student");
            }

        }

    }

    private Student mapTOStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();

        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setAddress(resultSet.getString("address"));

        return student;


    }
}
