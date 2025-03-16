package com.example.studentmarkingsystem.repository;

import com.example.studentmarkingsystem.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Mark, Long> {
}
