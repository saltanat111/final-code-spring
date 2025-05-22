package com.example.studentmarkingsystem.repository;

import com.example.studentmarkingsystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
//@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
}
