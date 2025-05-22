package com.example.studentmarkingsystem.repository;

import com.example.studentmarkingsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByStudentUsername(String studentUsername);

//    @Query("select u from students where u.")
//
//    @Query("SELECT u FROM User u WHERE u.username = :username")
//    //Optional<User> findUserByUsername(@Param("username") String username);
}
