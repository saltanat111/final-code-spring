package com.example.studentmarkingsystem.entity.Principal;

import com.example.studentmarkingsystem.entity.Admin;
import com.example.studentmarkingsystem.entity.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class StudentPrincipal implements UserDetails {

        private Student student;

        public StudentPrincipal(Student student) {
            this.student = student;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singleton(new SimpleGrantedAuthority("STUDENT"));
        }

        @Override
        public String getPassword() {
            return student.getStudentPassword();
        }

        @Override
        public String getUsername() {
            return student.getStudentUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }


