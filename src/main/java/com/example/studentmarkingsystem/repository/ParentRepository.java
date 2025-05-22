package com.example.studentmarkingsystem.repository;

import com.example.studentmarkingsystem.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    Optional<Parent> findByParentUsername(String parentUsername);

}
