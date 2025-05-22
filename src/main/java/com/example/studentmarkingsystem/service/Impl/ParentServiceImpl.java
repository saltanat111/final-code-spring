//package com.example.studentmarkingsystem.service.impl;
//
//import com.example.studentmarkingsystem.entity.Parent;
//import com.example.studentmarkingsystem.repository.ParentRepository;
//import com.example.studentmarkingsystem.service.ParentService;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ParentServiceImpl implements ParentService {
//
//    private final ParentRepository parentRepository;
//
//    public ParentServiceImpl(ParentRepository parentRepository) {
//        this.parentRepository = parentRepository;
//    }
//
//    @Override
//    public Optional<Parent> findByParentUsername(String parentUsername) {
//        return parentRepository.findByParentUsername(parentUsername);
//    }
//
//    // ... other methods ...
//}