package com.example.studentmarkingsystem.repository;

import com.example.studentmarkingsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByTeacherUsername(String teacherUsername);

}
