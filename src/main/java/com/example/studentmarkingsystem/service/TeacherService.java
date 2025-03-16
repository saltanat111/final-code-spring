package com.example.studentmarkingsystem.service;

import com.example.studentmarkingsystem.entity.Teacher;
import com.example.studentmarkingsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacherDetails) {
        Teacher teacher = getTeacherById(id);
        teacher.setTeacherUsername(teacherDetails.getTeacherUsername());
        teacher.setTeacherPassword(teacherDetails.getTeacherPassword());
        teacher.setTeacherCourse(teacherDetails.getTeacherCourse());
        teacher.setTeacherCourseId(teacherDetails.getTeacherCourseId());
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}