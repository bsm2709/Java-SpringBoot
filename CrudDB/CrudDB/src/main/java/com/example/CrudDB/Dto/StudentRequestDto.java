package com.example.CrudDB.Dto;

import jakarta.validation.constraints.*;

public class StudentRequestDto {

    @NotBlank(message = "Name cant be blank/null")
    private String studentName;

    @NotNull(message = "Age cant be null")
    @Min(value = 15)
    private int age;

    @NotBlank(message = "Email cant be blank")
    @Email
    private String email;

    @NotNull(message = "Phone number cant be null")
    private Long phno;

    @NotBlank(message = "Course cant be null/Blank")
    private String courseOpted;

    @Size(max = 250)
    private String address;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhno() {
        return phno;
    }

    public void setPhno(Long phno) {
        this.phno = phno;
    }

    public String getCourseOpted() {
        return courseOpted;
    }

    public void setCourseOpted(String courseOpted) {
        this.courseOpted = courseOpted;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
