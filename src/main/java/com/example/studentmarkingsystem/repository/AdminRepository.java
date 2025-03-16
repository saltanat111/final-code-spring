package com.example.studentmarkingsystem.repository;

import com.example.studentmarkingsystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}