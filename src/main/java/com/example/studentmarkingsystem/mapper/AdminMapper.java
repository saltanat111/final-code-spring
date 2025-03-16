package com.example.studentmarkingsystem.mapper;

import com.example.studentmarkingsystem.dto.AdminDTO;
import com.example.studentmarkingsystem.entity.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public AdminDTO toDto(Admin admin) {
        AdminDTO dto = new AdminDTO();
        dto.setId(admin.getId());
        dto.setAdminUsername(admin.getAdminUsername());
        dto.setAdminPassword(admin.getAdminPassword());
        return dto;
    }

    public Admin toEntity(AdminDTO dto) {
        Admin admin = new Admin();
        admin.setId(dto.getId());
        admin.setAdminUsername(dto.getAdminUsername());
        admin.setAdminPassword(dto.getAdminPassword());
        return admin;
    }
}