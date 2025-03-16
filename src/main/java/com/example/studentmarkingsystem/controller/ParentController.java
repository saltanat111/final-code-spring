package com.example.studentmarkingsystem.controller;

import com.example.studentmarkingsystem.dto.ParentDTO;
import com.example.studentmarkingsystem.entity.Parent;
import com.example.studentmarkingsystem.mapper.ParentMapper;
import com.example.studentmarkingsystem.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/parents")
public class ParentController {
    @Autowired
    private ParentService parentService;
    @Autowired
    private ParentMapper parentMapper;

    @GetMapping
    public List<ParentDTO> getAllParents() {
        return parentService.getAllParents().stream()
                .map(parentMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentDTO> getParentById(@PathVariable Long id) {
        Parent parent = parentService.getParentById(id);
        return ResponseEntity.ok(parentMapper.toDto(parent));
    }

    @PostMapping
    public ResponseEntity<ParentDTO> createParent(@RequestBody ParentDTO parentDTO) {
        Parent parent = parentMapper.toEntity(parentDTO);
        Parent savedParent = parentService.createParent(parent);
        return ResponseEntity.ok(parentMapper.toDto(savedParent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParentDTO> updateParent(@PathVariable Long id, @RequestBody ParentDTO parentDTO) {
        Parent parent = parentMapper.toEntity(parentDTO);
        Parent updatedParent = parentService.updateParent(id, parent);
        return ResponseEntity.ok(parentMapper.toDto(updatedParent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
        return ResponseEntity.noContent().build();
    }
}