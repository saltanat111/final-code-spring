package com.example.studentmarkingsystem.repository;

import com.example.studentmarkingsystem.entity.Admin;
import com.example.studentmarkingsystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByAdminUsername(String adminUsername);
}