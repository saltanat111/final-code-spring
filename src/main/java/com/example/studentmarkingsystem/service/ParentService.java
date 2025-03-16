package com.example.studentmarkingsystem.service;

import com.example.studentmarkingsystem.entity.Parent;
import com.example.studentmarkingsystem.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    @Autowired
    private ParentRepository parentRepository;

    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    public Parent getParentById(Long id) {
        return parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));
    }

    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public Parent updateParent(Long id, Parent parentDetails) {
        Parent parent = getParentById(id);
        parent.setParentUsername(parentDetails.getParentUsername());
        parent.setParentPassword(parentDetails.getParentPassword());
        parent.setStudentId(parentDetails.getStudentId());
        return parentRepository.save(parent);
    }

    public void deleteParent(Long id) {
        parentRepository.deleteById(id);
    }
}