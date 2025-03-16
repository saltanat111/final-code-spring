package com.example.studentmarkingsystem.mapper;

import com.example.studentmarkingsystem.dto.ParentDTO;
import com.example.studentmarkingsystem.entity.Parent;
import org.springframework.stereotype.Component;

@Component
public class ParentMapper {
    public ParentDTO toDto(Parent parent) {
        ParentDTO dto = new ParentDTO();
        dto.setId(parent.getId());
        dto.setParentUsername(parent.getParentUsername());
        dto.setParentPassword(parent.getParentPassword());
        dto.setStudentId(parent.getStudentId());
        return dto;
    }

    public Parent toEntity(ParentDTO dto) {
        Parent parent = new Parent();
        parent.setId(dto.getId());
        parent.setParentUsername(dto.getParentUsername());
        parent.setParentPassword(dto.getParentPassword());
        parent.setStudentId(dto.getStudentId());
        return parent;
    }
}