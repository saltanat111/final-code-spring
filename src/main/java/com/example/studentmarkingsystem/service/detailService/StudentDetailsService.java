package com.example.studentmarkingsystem.service.detailService;

import com.example.studentmarkingsystem.entity.Admin;
import com.example.studentmarkingsystem.entity.Student;
import com.example.studentmarkingsystem.repository.AdminRepository;
import com.example.studentmarkingsystem.repository.StudentRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("studentDetailsService")
public class StudentDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;

    public StudentDetailsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByStudentUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Student not found with username: " + username));
        return new User(student.getStudentUsername(), student.getStudentPassword(), Collections.singletonList(() -> "ROLE_STUDENT"));
    }
}
