package com.example.studentmarkingsystem.service.detailService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("generalUserDetailsService")
public class GeneralUserDetailService implements UserDetailsService {

    private final UserDetailsService adminDetailsService;
    private final UserDetailsService teacherDetailsService;
    private final UserDetailsService parentDetailsService;
    private final UserDetailsService studentDetailsService;

    public GeneralUserDetailService(
            @Qualifier("adminDetailsService") UserDetailsService adminDetailsService,
            @Qualifier("teacherDetailsService") UserDetailsService teacherDetailsService,
            @Qualifier("parentDetailsService") UserDetailsService parentDetailsService,
            @Qualifier("studentDetailsService") UserDetailsService studentDetailsService) {
        this.adminDetailsService = adminDetailsService;
        this.teacherDetailsService = teacherDetailsService;
        this.parentDetailsService = parentDetailsService;
        this.studentDetailsService = studentDetailsService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;

        try {
            userDetails = adminDetailsService.loadUserByUsername(username);
            // If no exception, user is an admin
            return userDetails;
        } catch (UsernameNotFoundException e) {
            // Admin not found, try teacher
        }

        try {
            userDetails = teacherDetailsService.loadUserByUsername(username);
            // If no exception, user is a teacher
            return userDetails;
        } catch (UsernameNotFoundException e) {
            // Teacher not found, try parent
        }

        try {
            userDetails = parentDetailsService.loadUserByUsername(username);
            // If no exception, user is a parent
            return userDetails;
        } catch (UsernameNotFoundException e) {
            // Parent not found, try student
        }

        try {
            userDetails = studentDetailsService.loadUserByUsername(username);
            // If no exception, user is a student
            return userDetails;
        } catch (UsernameNotFoundException e) {
            // Student not found, user doesn't exist in any role
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        //return userDetails; // Should not reach here if exceptions are handled correctly
    }
}
