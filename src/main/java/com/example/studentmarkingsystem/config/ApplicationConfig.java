//package com.example.studentmarkingsystem.config;
//
//import com.example.studentmarkingsystem.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//@Configuration
////@RequiredArgsConstructor
//public class ApplicationConfig {
//
//    private final UserRepository repository;
//
//    public ApplicationConfig(UserRepository repository) {
//        this.repository = repository;
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return username -> repository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        }
//
//}
