package com.example.studentmarkingsystem.service.detailService;

import com.example.studentmarkingsystem.entity.Parent;
import com.example.studentmarkingsystem.entity.Teacher;
import com.example.studentmarkingsystem.repository.ParentRepository;
import com.example.studentmarkingsystem.repository.TeacherRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("teacherDetailsService")
public class TeacherDetailService implements UserDetailsService {
    private final TeacherRepository teacherRepository;

    public TeacherDetailService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = teacherRepository.findByTeacherUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Teacher not found with username: " + username));
        return new User(teacher.getTeacherUsername(), teacher.getTeacherPassword(), Collections.singletonList(() -> "ROLE_TEACHER"));
    }
}
