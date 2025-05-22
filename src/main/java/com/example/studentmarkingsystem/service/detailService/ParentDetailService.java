package com.example.studentmarkingsystem.service.detailService;

import com.example.studentmarkingsystem.entity.Parent;
import com.example.studentmarkingsystem.entity.Student;
import com.example.studentmarkingsystem.repository.ParentRepository;
import com.example.studentmarkingsystem.repository.StudentRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("parentDetailsService")
public class ParentDetailService implements UserDetailsService {
    private final ParentRepository parentRepository;

    public ParentDetailService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Parent parent = parentRepository.findByParentUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Parent not found with username: " + username));
        return new User(parent.getParentUsername(), parent.getParentPassword(), Collections.singletonList(() -> "ROLE_PARENT"));
    }
}
