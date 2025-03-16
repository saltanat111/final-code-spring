package com.example.studentmarkingsystem.mapper;

import com.example.studentmarkingsystem.dto.StudentDTO;
import com.example.studentmarkingsystem.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDTO toDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setStudentId(student.getStudentId());
        dto.setStudentUsername(student.getStudentUsername());
        dto.setStudentPassword(student.getStudentPassword());
        return dto;
    }

    public Student toEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setStudentId(dto.getStudentId());
        student.setStudentUsername(dto.getStudentUsername());
        student.setStudentPassword(dto.getStudentPassword());
        return student;
    }
}
