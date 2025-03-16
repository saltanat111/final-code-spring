package com.example.studentmarkingsystem.mapper;

import com.example.studentmarkingsystem.dto.MarkDTO;
import com.example.studentmarkingsystem.entity.Mark;
import org.springframework.stereotype.Component;

@Component
public class MarkMapper {
    public MarkDTO toDto(Mark mark) {
        MarkDTO dto = new MarkDTO();
        dto.setId(mark.getId());
        dto.setStudentId(mark.getStudentId());
        dto.setTeacherCourse(mark.getTeacherCourse());
        dto.setMark(mark.getMark());
        return dto;
    }

    public Mark toEntity(MarkDTO dto) {
        Mark mark = new Mark();
        mark.setId(dto.getId());
        mark.setStudentId(dto.getStudentId());
        mark.setTeacherCourse(dto.getTeacherCourse());
        mark.setMark(dto.getMark());
        return mark;
    }
}