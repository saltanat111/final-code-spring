package com.example.studentmarkingsystem.controller;

import com.example.studentmarkingsystem.dto.ParentDTO;
import com.example.studentmarkingsystem.entity.Mark;
import com.example.studentmarkingsystem.entity.Parent;
import com.example.studentmarkingsystem.mapper.ParentMapper;
import com.example.studentmarkingsystem.service.MarkService;
import com.example.studentmarkingsystem.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/parents")
@PreAuthorize("hasAnyRole('ADMIN')")
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
    @PreAuthorize("hasAnyRole('PARENT')")
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

    private final ParentService parentService2;
    private final MarkService marksService;

    public ParentController(ParentService parentService, MarkService marksService) {
        this.parentService2 = parentService;
        this.marksService = marksService;
    }

//    @GetMapping("/child/marks")
//    public ResponseEntity<List<Mark>> getChildMarks(Authentication authentication) {
//        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            String username = userDetails.getUsername();
//
//            Parent parent = parentService.findByParentUsername(username);
//
//            if (parent != null) {
//                Integer childStudentId = parent.getStudentId();
//                List<Marks> childMarks = marksService.findByStudentId(childStudentId);
//                return ResponseEntity.ok(childMarks);
//            }
//        }
//        return ResponseEntity.status(401).build();
//    }
}