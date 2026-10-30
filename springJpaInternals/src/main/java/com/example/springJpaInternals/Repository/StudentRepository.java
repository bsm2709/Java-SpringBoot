package com.example.springJpaInternals.Repository;

import com.example.springJpaInternals.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    public StudentRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //Add student to DB
    public void add(Student student){
        student.setCreatedAt(LocalDateTime.now());
        entityManager.persist(student);
    }

    //Get by id
    public Student getById(long id){
        Student student = entityManager.getReference(Student.class, id );
        return student;
    }

//    Delete student by id
    public void deleteStudent(Long id){
        Student student = entityManager.getReference(Student.class, id );
        entityManager.remove(student);
    }

}
