package com.example.studentmarkingsystem.mapper;

import com.example.studentmarkingsystem.dto.TeacherDTO;
import com.example.studentmarkingsystem.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public TeacherDTO toDto(Teacher teacher) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacher.getId());
        dto.setTeacherUsername(teacher.getTeacherUsername());
        dto.setTeacherPassword(teacher.getTeacherPassword());
        dto.setTeacherCourse(teacher.getTeacherCourse());
        dto.setTeacherCourseId(teacher.getTeacherCourseId());
        return dto;
    }

    public Teacher toEntity(TeacherDTO dto) {
        Teacher teacher = new Teacher();
        teacher.setId(dto.getId());
        teacher.setTeacherUsername(dto.getTeacherUsername());
        teacher.setTeacherPassword(dto.getTeacherPassword());
        teacher.setTeacherCourse(dto.getTeacherCourse());
        teacher.setTeacherCourseId(dto.getTeacherCourseId());
        return teacher;
    }
}