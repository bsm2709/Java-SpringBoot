package com.example.CrudDB.Repository;

import com.example.CrudDB.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByIdAndDeletedIsFalse(Long id);
    public List<Student> findByDeletedFalse();
}
