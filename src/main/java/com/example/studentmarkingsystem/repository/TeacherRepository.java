package com.example.studentmarkingsystem.repository;

import com.example.studentmarkingsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
