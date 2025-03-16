package com.example.studentmarkingsystem.service;

import com.example.studentmarkingsystem.entity.Mark;
import com.example.studentmarkingsystem.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {
    @Autowired
    private MarkRepository markRepository;

    public List<Mark> getAllMarks() {
        return markRepository.findAll();
    }

    public Mark getMarkById(Long id) {
        return markRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mark not found with id: " + id));
    }

    public Mark createMark(Mark mark) {
        return markRepository.save(mark);
    }

    public Mark updateMark(Long id, Mark markDetails) {
        Mark mark = getMarkById(id);
        mark.setStudentId(markDetails.getStudentId());
        mark.setTeacherCourse(markDetails.getTeacherCourse());
        mark.setMark(markDetails.getMark());
        return markRepository.save(mark);
    }

    public void deleteMark(Long id) {
        markRepository.deleteById(id);
    }
}