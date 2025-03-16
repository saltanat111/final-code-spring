package com.example.studentmarkingsystem.repository;

import com.example.studentmarkingsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
